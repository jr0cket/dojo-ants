
(ns dojo-ants.core)

(defn create-map
  "Create two-dimensional vector for world completely covered by fog of war"
  [x y]
  (vec (repeat y (vec (repeat x :unknown)))))

(def command-map {"a" (fn [_ owner] (if (= "0" owner) :friend :foe)) "f" (constantly :food) "w" (constantly :water)} )

(defn parse-current-world
  "Apply command and arguments to specified world"
  [world command]
  (let [[type x y & owner] (seq (.split command " "))]
    (apply update-in world [(Integer/parseInt y) (Integer/parseInt x)] (command-map type) owner)))

(defn is-item-here? [item x y world]
  (= item (get-in world [y x])))

(defn is-ant-here? [x y world] (or (is-item-here? :friend x y world) (is-item-here? :foe x y world)))
(def is-food-here? (partial is-item-here? :food))
(def is-friend-here? (partial is-item-here? :friend))
(def is-foe-here? (partial is-item-here? :foe))
(def is-water-here? (partial is-item-here? :water))

  