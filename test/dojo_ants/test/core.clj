(ns dojo-ants.test.core
  (:use [dojo-ants.core])
  (:use [clojure.test]))

(deftest create-map-returns-correct-empty-map
  (is (= 10 (count (create-map 20 10))))
  (is (= 20 (count (first (create-map 20 10))))))

(deftest parse-ant-location
  (is (is-ant-here? 0 0 (parse-current-world [ [nil] ] "a 0 0 0")))
  (is (is-friend-here? 0 0 (parse-current-world [ [nil] ] "a 0 0 0")))
  (is (is-foe-here? 0 0 (parse-current-world [ [nil] ] "a 0 0 1")))
  (is (is-food-here? 0 0 (parse-current-world [[nil]] "f 0 0"))))

(deftest parse-ant-with-real-location
  (is (is-ant-here? 0 0 (parse-current-world [ [nil] ] "a 0 0 0")))
  (is (is-friend-here? 1 2 (parse-current-world (create-map 4 4) "a 1 2 0")))
  (is (is-foe-here? 2 3 (parse-current-world (create-map 4 4) "a 2 3 1")))
  (is (is-food-here? 3 4 (parse-current-world (create-map 6 6) "f 3 4")))
  (is (is-water-here? 4 5 (parse-current-world (create-map 6 6 ) "w 4 5"))))

(deftest parse-multiple-commands
  (let [first-ant-world (parse-current-world (create-map 5 5) "a 1 2 0")
        ant-plus-food (parse-current-world first-ant-world "f 3 4")]
    (is (is-friend-here? 1 2 ant-plus-food))
    (is (is-food-here? 3 4 ant-plus-food)))
  )