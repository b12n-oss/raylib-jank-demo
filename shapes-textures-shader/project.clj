(defproject net.b12n.raylib-jank-demo/shapes-textures-shader "0.1-SNAPSHOT"
  :license {:name "EPL-2.0" :url "https://www.eclipse.org/legal/epl-2.0/"}
  :plugins [[org.jank-lang/lein-jank "2026.06-1"]]
  :middleware [leiningen.jank/middleware]
  :dependencies [[org.jank-lang.commons/raylib-sys "2026.08-2"]]
  ;; ../common/src holds the shared helpers (net.b12n.raylib-jnk.rlights and co).
  :source-paths ["src" "../common/src"]
  :main net.b12n.raylib-jnk.scenes.shapes-textures-shader
  ;; One target dir for every demo, so raylib-sys is built natively once.
  :jank {:target-dir "../target"
         :optimization-level 2})
