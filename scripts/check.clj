(ns check
  "Offline gates for the demos (`bb check`).

  Deliberately does NOT compile anything. Compiling a demo needs a working
  jank, and building jank means building Clang, which is far beyond a per-PR
  job, so a real compile gate is not available here. What IS available is
  everything that goes wrong before the compiler is reached, which in practice
  is most of it. Every check runs in well under a second.

  - every .jank source (the scenes and common/) reads to EOF without a reader
    error, which catches unbalanced parens, including a stray trailing one
  - the EDN the tooling reads at runtime parses
  - demos.edn, the demo directories, the per-demo tasks in bb.edn and the
    gallery agree (that part is `bb gen --check`, run by the bb task)

  Brought over from raylib-jnk's bb/check.clj with the examples."
  (:require
   [babashka.fs :as fs]
   [clojure.edn :as edn]))

(def root (str (fs/parent (fs/parent (fs/absolutize *file*)))))

(defn- jank-sources []
  ;; */src matches common/src as well as every demo.
  (sort (map str (fs/glob root "*/src/**/*.jank"))))

(defn- syntax-errors
  "Read each file to EOF. Not `read-string`, which consumes only the first form,
  so a file whose imbalance comes after the first defn would pass it."
  []
  (->> (jank-sources)
       (keep (fn [f]
               (let [r (java.io.PushbackReader. (java.io.StringReader. (slurp f)))]
                 (try
                   (loop []
                     (when-not (= ::eof (read {:read-cond :allow :eof ::eof} r))
                       (recur)))
                   nil
                   (catch Exception e
                     (str (fs/relativize root f) " - " (.getMessage e)))))))
       vec))

(defn- edn-errors []
  (->> ["demos.edn" "scripts/demo_manifest.edn" "docs/demos/ledger.edn"]
       (keep (fn [f]
               (let [p (fs/file root f)]
                 (when (fs/exists? p)
                   (try (edn/read-string (slurp p)) nil
                        (catch Exception e (str f " - " (.getMessage e))))))))
       vec))

(defn -main [& _]
  (let [n (count (jank-sources))
        results [["every .jank source reads to EOF" (syntax-errors)]
                 ["tooling EDN parses" (edn-errors)]]]
    (doseq [[label errs] results]
      (if (seq errs)
        (do (println (str "FAIL " label))
            (doseq [e errs] (println (str "    " e))))
        (println (str "ok   " label))))
    (println (str n " .jank sources checked"))
    (when (some (comp seq second) results)
      (System/exit 1))))

(when (= *file* (System/getProperty "babashka.file"))
  (apply -main *command-line-args*))
