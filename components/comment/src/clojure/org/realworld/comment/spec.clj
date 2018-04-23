(ns clojure.org.realworld.comment.spec
  (:require [clojure.org.realworld.spec.interface :as spec]
            [clojure.org.realworld.profile.spec :as profile-spec]
            [spec-tools.core :as st]
            [spec-tools.data-spec :as ds]))

(def id
  (st/spec {:spec        pos-int?
            :type        :long
            :description "A long spec that defines a comment id which is a positive integer"}))

(def add-comment
  (ds/spec {:name :core/add-comment
            :spec {:body spec/non-empty-string?}}))

(def comment-spec
  (ds/spec {:name :core/comment
            :spec {:id        pos-int?
                   :updatedAt string?
                   :createdAt string?
                   :body      spec/non-empty-string?
                   :author    profile-spec/profile}}))

(def visible-comment
  (ds/spec {:name :core/visible-comment
            :spec {:comment comment-spec}}))
