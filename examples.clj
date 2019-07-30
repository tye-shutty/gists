;;these code snipits and advice are not mine, I just copied these from various websites.

(Character/isAlphabetic <int>)
;True if char index is a letter 

(set! *warn-on-reflection* true) 
;Put at beginning of file to check for slow code

;;defn- 
(def ^:private foo 1)
;ns private
ns-2=>(deref (var user/foo)) ;or @(var user/foo)
;1

;;fn [a b & [c]] 
;discards input after c away
(defn a [& {:keys [b] :as c}] (prn c (inc b)))
(a :b 2)
;{:b 2} 3
(defn a [& b] (prn b))
(a :b 2)
;(:b 2)

(-> <value> <expression1> <expsn2> ... )
;(-> 2 (- 4) (/ 3))
;=> -2/3 inserts into leftmost exprsn in first pos, then the result into the next expsn

(->> 2 (- 4) (/ 3))
;=> 3/2 inserts into leftmost exprsn in last pos

(as-> 2 x (- x 4) (/ 3 x))
;=> -3/2

(def <funcname> (memoize <func>)) 
;Calling funcname will only run once for each unique argument, else return cached result

;;java
(import java.util.Date) ;or (ns <symbol> (:import (java.util Date)))
(Date.) ;or (java.util.Date.)
(. (java.time.LocalDateTime/now) toString)
;"2019-07-12T16:02:58.825"
(.parse (java.text.SimpleDateFormat. "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'") "1985-04-12T23:20:50.52Z")
;#inst "1985-04-13T03:20:50.052-00:00"
(. #inst "1985-04-12T23:20:50.52Z" getTime) #_or (.getTime #inst "1985-04-12T23:20:50.52Z")
;482196050520
;;https://github.com/dm3/clojure.java-time
;;https://clojure.github.io/clojure/clojure.instant-api.html
;;java.sql.Timestamp

java.lang.Thread$UncaughtExceptionHandler
;$ used to refer to inner classes
 ;java uses a dot in the class name: Thread.UncaughtExceptionHandler
 
(.run (fn [] (pr "hi") (inc 3)))
;"hi"nil
(.call (fn [] (pr "hi") (inc 3)))
;"hi"4

(Character/getNumericValue \0)
;0 ;\a = 10 etc

;;destructuring / dereferencing
(let [{:keys [a c]} {:a 1 :b 2 :c 3} {:keys [d e]} {:d 4 :e 3}] (+ a d))
;5
(defn c [{:keys [e] {:keys [b]} :d}] (str e b))
(c {:d {:b 4} :e 2})
;"24"
(defn c [{{{:keys [b]} :d} :a}] (str b))
(c {:a {:d {:b 4} :e 2}})
;"4"
(let [{{:keys [type]} :extracted-params} {:extracted-params {:type "hey"}}] type)
;"hey"
(let [{{a :b} :c} {:c {:b 5}}] a)
;5
(let [[s {:keys [a] :as e}] ["hi" {:a 1 :b 2}]] (str a e))
;"1{:a 1, :b 2}"
(let [{:keys [a]} '(:a 1)] a)
;1
(defn b [& {:keys [a]}] a)
(b :a 2)
;2
(let [{a :b :keys [c]} {:b 1 :c 3}] (vector a c))
;[1 3]

;;deps.edn
{:deps {clj-time {:mvn/version "0.14.2"} org.clojure/core.async {:mvn/version "0.4.500"}}
;;clj
(require '[clj-time.core :as time] '[clojure.core.async :as a])
 ;seems to refer to the path to the ns relative to the src/ or src/main/clojure/
;or {:deps {org.clojure/data.csv {:git/url "https://github.com/clojure/data.csv.git" :sha "e5beccad0bafdb8e78f19cba481d4ecef5fabf36"}}} 
(use '[clojure.string :only [trim]])

 (ns <sym> (:use [clojure.string]))
(ns time (:refer-clojure :exclude [time]))
;only works when ns created
(refer 'clojure.string :rename '{capitalize cap, trim trm} :only '[capitalize trim])
 ;or (ns d (:require [clojure.string :refer [capitalize] :rename {capitalize cap}]))
(cap "hIgh")
;"High"

(defn test1 [{:keys [a b]}] (+ a b)) 
(test1 {:a 1 :b 2 :c 3})
;;3 

(defrecord <Typename> [<varname1> ^<typefor2> <varname2> ...])
;type hints will not throw exceptions, just for documentation, shorthand for ^{:tag <typefor2>}
;Given (defrecord TypeName ...), two factory functions will be defined: ->TypeName, taking positional parameters 
;for the fields, and map->TypeName, taking a map of keywords to field values.
(def <objectname> (<Typename>. <value1> <value2> ...))
(:<varname1> <objectname>)
;<value1>

;;[prismatic/schema "1.1.1"]
(s/defn ^:always-validate <symbol> [<var1> :- <type/schema> <var2> :- <type/schema> ...] (<function(s)>))
;plumatic/schema
(s/explain <symbol/functioncall>)
;=>shows what's happening
;;s/required-key
;map must always provide
(s/validate <symbol> <value>)
;returns value if correct type as that symbol's schema

(def FancySeq
  "A sequence that starts with a String, followed by an optional Keyword,
   followed by any number of Numbers."
  [(s/one s/Str "s") (s/optional s/Keyword "k") s/Num])

(def OddLong (s/both long (s/pred odd? 'odd?)))
(def SetOfAtLeastOneOddLong (s/both #{OddLong} (s/pred seq 'seq)))

::<charsequence>
;=>:<currentnamespace>/<charsequence>
::<alias>/<charsequence>
;=>:<alias'sfullnamespace>/<charsequence>

(qualified-keyword? :user/:keyword)
;true
(qualified-keyword? ::keyword)
;true
(derive <fullyqualifiedkeywordA> <fullyqualifiedkeywordB>)
;creates parent child rel-ship. Undo with underive
(isa? <fullyqualifiedkeywordA> <fullyqualifiedkeywordB>)
;=>true if (isa? child parent)
(instance? java.io.InputStream (:body req))
;tests if :body val is instance of InputStream class (includes interfaces)
(parents <fullyqualifiedkeywordA>)
;=><fullyqualifiedkeywordB>
(descendants <fullyqualifiedkeywordB>)
;=><fullyqualifiedkeywordA>
;ancestors will return parents of parents, etc<fullyqualifiedkeywordA>
(keyword "user" "k")
;:user/k
(namespace ::k) ;or (namespace 'user/x)
;"user"

(defmulti <symbol> (fn [<param1>] <function&/param>))
(defmethod <symbol> <functionresult1/:default> [<param2>] <value2>)
...
(<symbol> <value>)
;=><value2> maybe
(doseq [x [1 2 3] y [1 2]] (pr (* x y))) ;all about side effects
;122436nil
(dotimes [x 4] (pr x)) ;all about side effects
;0123nil
(for [x [1 2 3] y [1 2]] (* x y))
;(1 2 2 4 3 6) ;lazy-seq
(doall (map print [1 2 3]))
;123(nil nil nil)
(map print [1 2 3])
;(123nil nil nil)
(doseq [[a b] [[1 (partial + 1)][2 (partial + 2)]]] (pr (b a)))
;24nil
(for [[c d] [[1 2 3][4 5 6]]] [c d])
;([1 2] [4 5]) ;there is no symbol for the third position
(for [[c d] {:a 1}] [c])
;([:a])
(doseq [_ (range 10)] (a/thread (prn (for [x (range 3)] x))))
;all threads execute at once

(let [{a :b} {:b 1}] a)
;1
(let [{{:keys [a b]} :c} {:c {:a 1 :b 2}}] (+ a b))
;3
(assoc-in [{:a {:c 1 :b 2}}] [0 :a :c] 3) ;or (assoc-in [{:a {:c 1 :b 2}}] '(0 :a :c) 3)
;[{:a {:c 3, :b 2}}]

((fn [a & {:keys [b]}] (+ a b)) 1 :b 2)
;3
(let [{:keys [a/a1] :b/keys [b1]} {:a/a1 1 :b/b1 2}] (+ a1 b1))
;3
(create-ns '<symbol1>)
(alias '<symbol2> '<symbol1>)
(let [<symbol5> {::<symbol2>/<symbol3> <value> ::<symbol2>/<symbol4> <value} 
      {:keys [::<symbol2>/<symbol3> ::<symbol2>/<symbol4>]} <symbol5>] <function>)
;;allows easy change of ns

(let [[a b] [1 2]] (+ a b))
;3

((fn [{:keys [a] {:keys [c]} :b [e f] :d}] (pr a c e f)) {:a 1 :b {:c 2} :d [3 4]})
;1 2 3 4nil

(defprotocol A (b [this c] [this]))
;overloaded b
;methods are optional (protocol can be used as a marker, tested with )
(deftype D [e] A (b [this] e) (b [this c] (/ c e)))
(b (D. 2) 3) ;or (b #user.D[2] 3) ;defrecord can take a map of parameters instead
;3/2 The inner value (2) is specified by the object. The outer value (3) is specified by the protocol.
(.e (D. 2))
;2
(b (D. 2))
;2
(b (let [x 4] (reify A (b [this] (inc x)) (b [this c] (str "c= " c "x= " x)))))
;5 Let specifies the object-specified vars
;A can also be an object or interface
(b (let [x 4] (reify A (b [this] (inc x)) (b [this c] (str "c= " c " x= " x)))) 3)
;"c= 3 x= 4"
;;deftype vs defrecord
;defrecord supports mutable fields
;deftype provides no functionality not specified by the user, other than a constructor
(deftype G [])
(extend G A {:b (fn ([this c] (str this " & " c)) ([this] "hi"))})
;or (extend-type G A <func(s)> <other protocol func pair(s)>)
;or (extend-protocol A G <func(s)> <other type func pair(s)>)
;third var is empty map if no methods
(def H (G.))
(b H)
;"hi"
(instance? G H)
;true
(satisfies? A H)
;true
(ns-publics '<ns>)
;{x #'user/x, u #'user/u...} ;map of intern mappings (defined things)
(find-ns 'user)
;#object[clojure.lang.Namespace 0x18230356 "user"]
(ns-map 'user)
;{primitives-classnames #'clojure.core/primitives-classnames, +' #'clojure.core/+'...} 
;returns map of every symbol available

(defprotocol A (inc-count [this]))
(deftype D [count] A (inc-count [this] (+ count 1)))
(.count (D. (.inc-count (D. 2))))
;3 ;deftype fields are not mutable so new one needs to be created to update count
(defrecord D [count] A (inc-count [this] (assoc this :count (+ 1 count))))
;fields are mutable but the object isn't. Removing an initial field will transform defrecord into a map
(def f (D. 2))
(def f (inc-count f))
(def f (.inc-count f)) ;dot doesn't matter
(:count f)
;4

;;how to have mutatable fields:
(deftype B [thing])
(def c (B. (atom {:a "hi"})))
(reset! (.thing c) {:a "bye"})
@(.thing c)
;{:a "bye"}

(defprotocol user/B (c [this]) (d [this]))
(c (reify B (c [this] (inc (d this))) (d [this] 5)))
;6

(defn c [x] (inc x))
(let [x c] (x 4))
;5

(((partial partial + 1) 2) 3)
;6
((apply partial [+ 1]) 2)
;3

t=>(extend-protocol A java.lang.Object (b [this x] (str "hi " x)))
user=>(deftype C [])
user=>(type C)
;java.lang.Class
user=>(isa? C java.lang.Object)
;true
user=>(t/b (C.) "tye")
;"hi tye" 
user=>(extend-protocol t/A C (b [this x] (str "cheers " x)))
user=>(t/b (C.) "tye")
;"cheers tye" ;also overrides if done in same ns
user=>(b (C.) "tye")
;Unable to resolve symbol: b in this context

(seq {:a 1 :b 2})
;([:a 1] [:b 2])
(into {} ([:a 1] [:b 2]))
;{:a 1 :b 2}
;defrecords can be cast like this

(assert false "that's false")
;Execution error (AssertionError) at user/eval173 (REPL:1).
;Assert failed: that's false
;false ;if no message param the value takes its place
(assert true "that's false")
;nil
(try (assert false) (catch AssertionError e (str "sup: " (.getMessage e))) (finally (prn "yeah")))
;"yeah" ;will also print if true
;"sup: Assert failed: false"
(map StackTraceElement->vec  (try (assert false) (catch AssertionError e (.getStackTrace e))))
;([user$eval276$fn__277 invoke "NO_SOURCE_FILE" 1] [user$eval276 invokeStatic "NO_SOURCE_FILE" 1]...)
 
(update-in {:a {:b 2}} [:a :b] / 3)
;{:a {:b 2/3}}
(update-in [1 2 [1 2 3]] [2 0] inc)
;[1 2 [2 2 3]]
(update [1 2 3] 1 + 6 7)
;[1 15 3]
(update {:a 1 :b 3} :c #(if % % :doesn't-exist))
;{:a 1, :b 3, :c :doesn't-exist}

(def a (atom 0)) ;also ref, agent, and future ;can wrap a def those types and in a var
(deref a) ;or @a
;0
(def b (promise))
(deref b 100 :timeout) ;only works with promises
;:timeout ;(after 100 ms of blocking)
(realized? b)
;false
(deliver b 42)
@b
;42 ;blocks forever if not delivered

;;all defs create a var that points to the value specified
(def w 3)
(var w) ;or #'w
;#'user/w
(var-get (var w))
;3

((constantly :x) :b 1 /)
;:x

(deftest one (is (= 2 2)))
(deftest all (one) (two)...)
(run-tests 'user) ;ns is optional, default is current
;Testing user...

(def f (future (Thread/sleep 10000) (println "done") 100)) ;can use ...async/thread instead of future
;creates a new thread
@f
;done
;100
@f
;100 ;returns cached result
(def b (delay (prn "hi") 100))
@b
;"hi"100
@b
;100
(def e (promise))
(future (Thread/sleep 10000)
  (deliver e 1))
@e
;1 ;after 10 sec
(let [c (a/chan)] (a/go (a/>! c "hi")) (prn (a/<!! (a/go (a/<! c))) (a/close! c))) ;does not work outside go if unbuffered
;"hi" nil \nnil
;go block Asynchronously executes the body and creates channel for result
;go blocks are not bound to threads so you can make 1000s of channels with them
(let [c1 (a/chan) c2 (a/chan)] 
 (a/go (while true (let [[v ch] (a/alts! [c1 c2])] (println "read" v "from" ch)))) ;listens to all channels at once
 (a/go (a/>! c1 "hi")) (a/go (a/>! c2 "u"))) ;does not require go blocks
;read u from #object[... \nread hi from ...
(let [cs (repeatedly 10 chan)] ...)
;binds cs to a sequence of calls to chan
echo "(println \"tye\")" > one.clj
clojure one.clj
;tye
;;atoms retry changes if another thread has changed value part way --must be free of side effects

(if-let [e nil] e "waddup")
;"waddup"

(def a 1)
(with-redefs [a 2] a)
;temporary change (like let) but visible in all threads
(def chan1 (a/chan 2)) ;capacity to store 2 messages (queue datastructure)
(a/>!! chan1 "Hi Tye")
;true
(a/<!! chan1)
;"Hi Tye"
(a/close! chan1)
;can still read from but not put
(a/chan (a/dropping-buffer 10)) ;drops newest values when full
(a/chan (a/sliding-buffer 10)) ;drops oldest values

;;Your macro should output a list (form). The form will be evaluated when the macro is called (even if the form is quoted `). 
(defmacro z [a] (list str "hi " a)) ;or  (defmacro z [a] `(str "hi " ~a)); or (defmacro z [a] (str "hi " a))
(z "tye")
;"hi tye"
(defmacro z [a & b] `(str "hi " ~a ~@b)) ;if don't need to use tilde, can use ' or `
(z "tye" "dara" "ezra")
;"hi tyedaraezra"
(defmacro define-y [] (let [a 'y] `(do (def ~a 3) (list ~a)))) ;DANGEROUS will overwrite y
(defmacro define-x-safely [] (let [sym (gensym 'x)] `(do (def ~sym 2) (list ~sym))))
(defmacro b [c] (let [[d e f] c] `(defn ~d ~e ~f)))
(b (g [x] (inc x))) ;note that g is not being called!
(g 2)
;3
(defmacro l [a]  (str a))
(l (+ 1 1))
;"(+ 1 1)"
(defmacro a [x] (let [[sym param args] x] `(def z (into {} [[~(keyword sym) (fn ~param ~args)]]))))
(a (b [c] (inc c)))
((:b z) 2)
;3 ;or ((:b {:b (fn [x] (inc x))}) 2)
(defmacro c [d] (def d 2))
;d is just a symbol
(c b)
;b is input but discarded
d
;2
(defmacro c [d] `(defn ~d [] (inc 3)))
;d must have a tilde, or else it will evaluate d, and a symbol that points to a symbol, ie (def d (symbol "d")), is not valid
;because inc is not tilda'd I can redefine inc after defmacro and it wont affect the operation 
(c f)
;f is used as d
(f)
;4
(defmacro help [x f] `(~f ~x))
(defn a [x] (help x inc))
(a 3)
;4
(macroexpand `(help 3 inc))
;(clojure.core/inc 3)
(defmacro help2 [x f] (list inc `(~f ~x)))
(help2 3 inc)
;5
;;should not use macros to return a function: may work, may not:
(defmacro help3 [] inc)
(defmacro num1 [] 1)
((h4) 2)
(inc ((help3) (num1)))
;3
(defmacro h4 [] (partial + 1 2))
((h4) 2)
;No matching ctor 
;;macros should return a symbolic expression
(defmacro h4 [] `(partial + 1 2)) ;or (defmacro h4 [] '(partial + 1 2)) or (defmacro h4 [] (list partial + 1 2))
((h4) 2)
;5
(defmacro h4 [] (+ 1 2))
(h4)
;3
(defmacro expand-body [& body] `(println ~@body))
(macroexpand `(expand-body "test1" "test2"))
;(clojure.core/println "test1" "test2")
;;symbols in forms will resolve to the ns before being sent to the macro
(ns m)
(defmacro d [x] x)
(ns user)
(def a inc)
(def c (m/d (a 7)))
c
;8
;;macro quotes and escapes can be used in functions, but they can't be evaluated without going back into a macro
(defn e [x] `(inc ~x))
(e 4)
;(clojure.core/inc 4)
(defmacro f [] (e 5))
(f)
;6
;;or using eval
(eval (e 4))
;5
;;;most essentially, the forms outputted are used to build functions
(defmacro b [] `(inc 4))
(def c (b))
c
;5
(defmacro show-env [] (println &env))
(let [a :p b :t] (show-env))
;{a #object[clojure.lang.Compiler$LocalBinding 0x38f116f6 clojure.lang.Compiler$LocalBinding@38f116f6], 
 ;b #object[clojure.lang.Compiler$LocalBinding 0x5286c33a clojure.lang.Compiler$LocalBinding@5286c33a]}
(defmacro show-form [a b] (pr &form))
(show-form :k :j)
;(show-form :k :j)
(defmacro show-form [a b] (str (next &form)))
(show-form :k :j)
;"(:k :j)"
(defmacro show-form [a b] (meta &form))
(show-form :k :j)
;{:line 1, :column 1}
(defmacro a [b] (let [b1 (str b 1)] `(defmacro ~(symbol b1) "doc string" ~'{:arglists '([& k1] [k2 & k1])} [& e#] `(prn ~~b ~@e#))))
;the double tilde is needed or else it will look for user/b (because macro inside macro)
;if the @ is excluded the first element of e# will be treated as a function
;the arglists provides metadata, if backquotes are used k1 and k2 are given a namespace prefix, used perhaps because the gensym has an unknown symbol
(defmacro b [] *ns*)
(b)
;#object[clojure.lang.Namespace 0x66ce957f "user"]
(ns test)
(str (user/b))
;"test"

 
(let [a 2] (cond (= a 1) "sup"))
;nil 
(cond-> 1 (= 1 1) ((fn [x] (inc x))) (= -2 -2) ((fn [x] 4)) (= :a :a) inc true (/ 3) false (* 3))
;can't thread into test expressions, just threads into expressions after true tests
;5/3
(let [a 1] (cond (= a 1) "sup" (= 1 1) "cheese"))
;"sup"
(case 501 (500 501 503) "hi" 504 "bye" "default")
;"hi"
;case requires value and will throw error if no default
(condp = \g \d "hiya" \c "nope" "jump")
;"jump"

lein deps :tree
;all your deps and their deps too

;;sets work similar to maps: the set is a function that takes the value, and return the value if it is in the set, else nil.
;if the value is a keyword it can be a function to test if it is in a set that follows

(concat [1] {"a" 2} '(3) #{4})
;(1 ["a" 2] 3 4)

(defn c [^clojure.lang.PersistentVector header-cols col]  (.indexOf header-cols col))
(c '(:a :b :c) :b)
;Execution error (ClassCastException)
(defn d [header-cols col]  (.indexOf header-cols col))
(time (dotimes [_ 100000] (d [:a :b :c] :b)))
;"Elapsed time: 498.981584 msecs" ;much longer than c

[1 2 3 #_ 4 5]
;[1 2 3 5]

;;filter is the opposite of remove

2r101
;5 ;max radix is 36
36rz
;35
(* ##Inf -1)
;##-Inf

(format "%s is %d" "tye" 5)
;"tye is 5"

(defn a [] (pr 1) 2) ;can't do with def unless def points to anon function
;12

(defonce b 1)
(defonce b 2)
b
;1

(merge {:a 1 :b 2} {:b 3 :c 4} nil)
;{:a 1, :b 3, :c 4}

(pprint (make-array Integer/TYPE 2 3))
;[[0, 0, 0], [0, 0, 0]]

(spit (io/file "hulo.txt") "sup bro" :append true)
(if (.exists (io/file "hulo.txt")) (slurp (io/file "hulo.txt")))
;"sup bro"

(read-string "hi you")
;hi ;reads as a symbol
;;Do not use the read-* functions in clojure.core to deserialize untrusted Clojure code, as they can be unsafe.
(ns w (:require [clojure.edn :as edn]))
(edn/read-string "hi you")
;hi

;;first class functions
(defn r [x] (inc x))
(defn f [x y] (x y))
(f r 1)
;2

(str "hi" nil)
;"hi"

(and 1 2)
;2
(and nil 2)
;nil ;or false if false

(.equals "hi" "hi")
;true

;;binding is a more powerful let, in that the binding changes the var outside its scope, so if something in the 
;scope calls something outside, and that thing calls the var, it returns the rebound value

(.startsWith "tye" "t")
;true

(coll? {})
;true

(map list [1 2 3])
;((1) (2) (3))
(mapcat list [1 2 3]) ;or (apply concat (map list [1 2 3]))
;(1 2 3)

(subs "tyezra" 2 3)
;"e" ;last param optional
(.length "tye")
;3

(persistent! (conj! (pop! (transient [1 2 3])) 4))
;[1 2 4] ;can improve performance
(defn vrange2 [n] (loop [i 0 v (transient [])] (if (< i n) (recur (inc i) (conj! v i)) (persistent! v))))
;faster but can only be accessed by a single thread

(reduce f val coll)
;If val is not supplied, returns the result of applying f to the first 2 items in coll, then applying f to that result and the 3rd item, etc.
(reduce-kv #(conj % (str "pos: " %2 " val " %3 )) ["init!"] [3 4 5])
;["init!" "pos: 0 val 3" "pos: 1 val 4" "pos: 2 val 5"]
;also works with maps
(reduce (fn [t z] (reduced? (if (= z "z") (reduced "y") (+ z t)))) [1 2 "z"])
;true 
(reduced? (reduce (fn [t z] (if (= z "z") (reduced "y") (+ z t))) [1 2 "z"]))
;false
(reduce-kv (fn [a x y] (+ (case x "a" (* 3 y) "b" (* 4 y)) a)) 0 {"a" 1 "b" 2})
;11

 ;;Strings
(clojure.string/replace "class ns.ns2.ns3.name" #"(.*)\.(.*)$" "$2")
;"name"
(clojure.string/replace "thing" "t" "")
;"hing"
(apply str (remove #(= \t %) "thing"))
;"hing"
(clojure.string/join ", " [1 2 3])
;"1, 2, 3" 

potemkin/import-macro
;Given a macro in another namespace, defines a macro with the same name in the current namespace.
;Argument lists, doc-strings, and original line-numbers are preserved.

?:taoensso.timbre/#+clj
;probably indicates the following is clojure
 https://clojure.org/guides/reader_conditionals

;;hashes produce a unique number for every datastructure given to it, preserves equality.
(hash 1)
;1392991556
(hash (+ 0 1))
;1392991556

(rand-nth '(0 1 2 3 4))
;2

(. System exit 0) ;or (System/exit 0)
;dot calls the 2nd arg with the following params in the scope of the first arg.

(pipeline n to xf from close? ex-handler)
;Takes elements from the from channel and supplies them to the to channel, subject to the transducer xf, with parallelism n.

((comp #(/ % 3) #(+ 4 %)) 2)
;2
((comp keyword symbol) "hi")
;:hi
;this order is opposite for transducers
(transduce xform f init coll)
;Works like reduce. If init is not supplied, (f) will be called to produce it.
(transduce (comp (filter odd?) (map #(/ % 3))) list "start!" [1 2 3 4 5])
;(((("start!" 1/3) 1) 5/3)) ;like reduce
(into [] (comp (filter odd?) (map #(/ % 3))) [1 2 3 4 5])
;[1/3 1 5/3] ;or (sequence xform coll) which is not lazy
(transduce (interpose ",") conj (range 5))
;[0 "," 1 "," 2 "," 3 "," 4]

(def b (a/chan 3 (filter string?)))
(doseq [thing ["t" 1 "s" :w "p"]] (a/>!! b thing))
(for [_ [1 2 3]] (a/<!! b))
;("t" "s" "p")

(reduce #(if (= %2 "good") (and true %) (reduced "no thanks")) true ["good" "bad" "good" "good"])
;"no thanks" ;exits out of the reduce early

(filter identity [1 2 3 nil])
;(1 2 3)

 ;;streams
(with-open [r (clojure.java.io/input-stream "myfile.txt")] 
 (loop [c (.read r)] (if (not= c -1) (do (print (char c)) (recur (.read r))))))
;Evaluates body in a try expression with names bound to the values of the inits, and a finally clause that calls 
 ;(.close name) on each name in reverse order.
 (. (clojure.java.io/input-stream (byte-array (map (comp byte int) "hi"))) read)
 ;104

(contains? #{:a #{}} #{}) ;or (contains? {:a #{}} :a)
;true ;doesn't work for lists
(contains? [nil nil nil] 0)
;true ;checks index
 
 (compare-and-set! atom oldval newval)
 ;Atomically sets the value of atom to newval if and only if thecurrent value of the atom is identical to oldval.
  ;Returns true if set happened, else false
 
(load-file "src/apr24/first.clj")
;all forms will evaluate ;If your data structures or a string in them grow bigger than around 65,535 it crashes.
(ns apr24.first)
;or
(alias 'f 'apr24.first)
 
 (defn a [x] (str "a" x))
 (doto (a "s") (pr "b") (pr "c"))
 ;"as" "b""as" "c""as"
 
 ;;boot show -p
 ;shows dep conflicts
 ;;boot show -d
 ;shows deps tree
 ;;to load deps in intelliJ, put this in build.boot and run boot lein-generate, then click buttons in intellij after opening project.clj
 (defn- generate-lein-project-file! [& {:keys [keep-project] :or {keep-project true}}]
  (require 'clojure.java.io)
  (let [pfile ((resolve 'clojure.java.io/file) "project.clj")
        ; Only works when pom options are set using task-options!
        {:keys [project version]} (:task-options (meta #'boot.task.built-in/pom))
        prop #(when-let [x (get-env %2)] [%1 x])
        head (list* 'defproject (or project 'boot-project) (or version "0.0.0-SNAPSHOT")
               (concat
                 (prop :url :url)
                 (prop :license :license)
                 (prop :description :description)
                 [:dependencies (conj (get-env :dependencies)
                                      ['boot/core "2.6.0" :scope "compile"])
                  :repositories (get-env :repositories)
                  :source-paths (vec (concat (get-env :source-paths)
                                             (get-env :resource-paths)))]))
        proj (pp-str head)]
      (if-not keep-project (.deleteOnExit pfile))
      (spit pfile proj)))
(deftask lein-generate [] (with-pass-thru fs (generate-lein-project-file! :keep-project true)))

 ((-> "first" symbol resolve) [1 2 3])
 ;1 ;without resolve returns nil (symbol is resolved as #'clojure.core/first)
 
(ns-name (the-ns (ns-name 'user)))
;user ;the-ns returns the ns object
 
(some-> 1 inc dec vector rest count (#(if (= 0 %) nil 2)) nil?)
;nil ;applies first to second param, then result of 2nd to 3rd param, etc, until a result is nil or returns final result
(some #(% :a) [{:b 3} {:a 2}])
;2
(some #(% 1) [#(do % false) #(do % nil) #(if (= 1 %) 3 nil)])
;3
(some #{1} #{2 3 1})
;1

`(try (let ~arg1 ~arg2) (catch Exception e# (str "Error: " (.getMessage e#))))
;<symbol># makes a gensym

(clojure.walk/postwalk pr [[[1] 2] 2 3 4])
;1[nil]2[nil nil]234[nil nil nil nil]nil
;pr transforms each value to nil
(clojure.walk/postwalk #(do (pr (str %)) (identity %)) [[[[1] 2]] [[6 3]]])
;"1""[1]""2""[[1] 2]""[[[1] 2]]""6""3""[6 3]""[[6 3]]""[[[[1] 2]] [[6 3]]]"[[[[1] 2]] [[6 3]]]
(clojure.walk/prewalk #(do (pr (str %)) (identity %)) [[[[1] 2]] [[6 3]]])
;"[[[[1] 2]] [[6 3]]]""[[[1] 2]]""[[1] 2]""[1]""1""2""[[6 3]]""[6 3]""6""3"[[[[1] 2]] [[6 3]]]
;function must return the coll used to continue iterating across it

(def ^{:test (fn [] (assert (= b 2))) :doc "sup"} b 3)
(test #'b)
;Execution error (AssertionError) at user/fn (REPL:1).
;Assert failed: (= b 2)
(doc b)
;-------------------------
;user/b
;  sup
;nil

(source inc)
;(defn inc
;  "Returns a number one greater than num. Does not auto-promote
;  longs, will throw on overflow. See also: inc'"
;  {:inline (fn [x] `(. clojure.lang.Numbers (~(if *unchecked-math* 'unchecked_inc 'inc) ~x)))
;   :added "1.2"}
;  [x] (. clojure.lang.Numbers (inc x)))
;nil

(throw (Exception. "clojure machine broke"))
;Execution error at n/eval219 (REPL:1).
;clojure machine broke

(filter #{:a :b} '(:a :b :c :d))
;(:a :b)

#?(:clj  (Clojure expression)
   :cljs (ClojureScript expression)
   :cljr (Clojure CLR expression)
   :default (fallthrough expression))
;allow different dialects of Clojure to share common code


;;concurrency
(def answer (delay (* 2 2)))
(deref answer)
;4
;calculates only the first time dereferenced
;blocks subsequent threads from deref'ing
;;If you want to run something in another thread, you pass a Runnable to the constructor of a Thread, then start it. 
;;Luckily, Clojure has thought of this. You can use a function of zero arguments directly as a Runnable.
(.availableProcessors (Runtime/getRuntime))
;8
(time (dotimes [x 10] (do (apply + (range 1000000000)) (prn "hi" x))))
;"hi" 0 "hi" 1 "hi" 2 "hi" 3 "hi" 4 "hi" 5 "hi" 6 "hi" 7 "hi" 8 "hi" 9
;"Elapsed time: 75094.968516 msecs"
;nil
(time (dotimes [x 10] (future (do (apply + (range 1000000000)) (prn "hi" x)))))
;"Elapsed time: 0.285741 msecs"
;nil
;"hi" 4 "hi" 6 "hi" 1 "hi" 2 "hi" 5 "hi" 3 "hi" 8 "hi" 0 "hi" 9 "hi" 7
;took 40 seconds
(time (dotimes [x 10] (.start (Thread. (fn [] (apply + (range 1000000000)) (prn "hi" x))))))
;also took 40 seconds
(def pool (java.util.concurrent.Executors/newFixedThreadPool 2))
;2 threads is same speed as 8 on repl, for 30 sec programs
(dotimes [x 8] (.submit ^java.util.concurrent.ExecutorService pool 
                        ^Callable (fn [] (apply + (range 1000000000)) (prn "hi" x))))
;30 sec
(def pool (java.util.concurrent.ForkJoinPool.))
(defn recur-add [x] (proxy [java.util.concurrent.RecursiveTask] [] 
                           (compute [] (if (< x 0) 
                                         "end" 
                                         (let [execute (recur-add (dec x))] 
                                           (.fork execute) 
                                           (apply + (range 1000000000)) 
                                           (prn "hi" x) 
                                           (.join execute))))))
(.invoke pool (recur-add 8))
;40sec
(dotimes [x 8] (clojure.core.async/go (do (apply + (range 1000000000)) (prn "hi" x))))
;30sec

;;making collections
(conj [1] 2)
;[1 2]
(concat [1] [2])
;(1 2)
(conj {:a 1} {:b 2})
;{:a 1 :b 2} ;last map takes precedence if duplicates
(cons 1 [2])
;(1 2)
(type (conj (range 100) 99999)) ;or (type (conj (range 100) 99999))
;clojure.lang.Cons
(type (concat (range 100) '(99999)))
;clojure.lang.LazySeq
(drop 2 [ 1 2 3])
;(3)

;;Maps
(#{:a :b} :a)
;:a ;else nil
({:a 1} :b 0)
;0 ;default value ;keyword can be first
(set '(:a :b))
;#{:a :b}
(conj [:a] :b :c)
;[:a :b :c] ;like a queue
(conj '(:a) :b :c)
;(:c :b :a) ;like a stack
(conj {:a 1} [:b 2] [:c 3]) ;or (assoc {:a 1} :b 2 :c 3)
;{:a 1, :b 2, :c 3} ;like a queue
;;conj sets have no order
dissoc {:a "s" :b "e"} :a)
;{:b "e"}
(select-keys {:a 1 :b 2 :c 3} [:a :c :d])
;{:a 1, :c 3}
(hash-map :a 1 :b 2)
;{:a 1 :b 2}
(into {} [[:a 1][:b 2]])
;{:a 1 :b 2}
 
;;Strings
(clojure.string/split "t y" #"\s")
 ;["t" "y"]

*file*
;"NO_SOURCE_PATH"
 
;;multi-airity / overloading
 (defn rec ([a] (rec a (inc a))) ([a b] (list a b)))
 (rec 3)
 ;(3 4)
 
;;there are a new set of functions (volatile!, vswap!, vreset!, volatile?) to create and use volatile "boxes" to 
 ;hold state in stateful transducers. Volatiles are faster than atoms but give up atomicity guarantees so should 
 ;only be used with thread isolation.
(def s (volatile! 9))
@s
;9
(volatile? s)
;true
(vreset! s 3)
;3
(vswap! s + 10)
;13

(def a 7)
(alter-var-root #'a (fn [x] 3)
a
;3
