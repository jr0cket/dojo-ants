(defproject dojo-ants "1.0.0-SNAPSHOT"
  :description "A representation of the ants world, able to parse commands"
  :dependencies [[org.clojure/clojure "1.2.1"]
                 [org.clojure/clojure-contrib "1.2.0"]]
  :dev-dependencies [[swank-clojure "1.2.1"]
                     [org.clojars.rayne/autodoc "0.8.0-SNAPSHOT"]]
  :autodoc { :name "London Clojure dojo - Group 5", :page-title "Ants dojo Documentation"}

  ;; Only re-fetch dependencies when they change in project.clj or
  ;; when :library-path directory is empty.
  :checksum-deps true  
  
  :license {:name "Eclipse Public License - v 1.0"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo
            :comments "same as Clojure"}
  )
