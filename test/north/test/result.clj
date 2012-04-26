(ns north.test.result)

(use 'clojure.pprint)

(def run-specs #())
(def ^:dynamic test-list {})

(defn run-specs []
	(binding [test-list (assoc test-list "Feature name" {})]
		(println test-list)))

(defstruct suite-struct :name :context-list)
(defstruct context-struct :name :test-list)
(defstruct test-struct :name :fun)

(def tests
	(struct-map suite-struct 
		:name "Feature name" 
		:context-list [(struct-map context-struct 
			:name "Default" 
			:test-list [(struct-map test-struct 
							:name "Sample test" 
							:fun #{println "Uhu!"})
						(struct-map test-struct 
							:name "Another test" 
							:fun #{println "Another test"})])]))

(pprint tests)

(pprint "-----------")

(pprint (:context-list tests))