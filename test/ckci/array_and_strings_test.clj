(ns ckci.array-and-strings-test
  (:require [clojure.test :refer :all]
            [ckci.array-and-strings :refer :all]))


(deftest array-test
  (testing "Should true if string is unique"
    (is (= (is-unique "matheus") true)
        (= (is-unique-new-ds "") true))
    (is (= (is-unique "jooo") false)))

  (testing "Check permutation, should true if string are permutation"
    (are [expected s1 s2] (= expected (check-permutations s1 s2))
         true "" ""
         true "ab" "ba"
         true "abc" "cba"
         false "av" "bc"
         false "ak" "47"))

  (testing "Compressed string"
    (is (= (compression "aabcccccaaa") "a2b1c5a3"))
    (is (= (compression "aabc    aaa") "a2b1c1 4a3"))
    (is (= (compression "abc") "abc"))
    (is (= (compression "a") "a"))
    (is (= (compression "") "")))

  (testing "One way"
    (are [expected s1 s2] (= expected (one-away? s1 s2))
         true "" ""
         true "abc" "abb"
         false "av" "bc"
         false "ak" "47"
         true "pale" "bale"
         true "pale" "ple"
         true "pales" "pale")))

(deftest study-notes
  (testing "The distinct function should returns a
           lazy sequence of the elements
           of coll with duplicates removed"
    (is (= (distinct [1 2 2 1]) '(1 2)))))

(deftest study-notes
  (testing "The distinct? function used on is-unique-new-ds
            returns true if no two of the arguments are equal"
    (is (= (distinct? 1 2 2 1) false))))

(deftest study-notes-some-clojure-functions
  (testing "zipmap Returns a map with the keys mapped to the corresponding vals. "
    (let [zip1 (zipmap [:a :b :c] (repeat 0))]
      (is (= {:a 0 :b 0 :c 0} zip1)))))




