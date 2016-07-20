(ns devtools.defaults
  ; warning: when touching this ns form, update also eval-css-arg in defaults.clj
  (:require-macros [devtools.defaults :as d :refer [css span named-color]]))

(def prefs
  {; -- installation --------------------------------------------------------------------------------------------------------

   :features-to-install                           :default
   :print-config-overrides                        false
   :suppress-preload-install                      false
   :bypass-availability-checks                    false
   :file-reader                                   nil

   ; -- feature tweaks ------------------------------------------------------------------------------------------------------

   :seqables-always-expandable                    true
   :print-meta-data                               true

   ; -- verbosity controls --------------------------------------------------------------------------------------------------

   :max-print-level                               2
   :body-line-max-print-level                     3
   :max-header-elements                           5
   :min-sequable-count-for-expansion              3
   :max-number-body-items                         100
   :string-prefix-limit                           20
   :string-postfix-limit                          20
   :sanity-hint-min-length                        128
   :max-instance-header-fields                    3
   :max-instance-custom-printing-level            2
   :max-list-protocols                            5
   :max-protocol-method-arities-list              3

   ; by default, well known types will render only via cljs printer, we won't wrap them in the blue-ish type info
   ; TODO: make this list complete by cherry-picking stuff from cljs.core
   :well-known-types                              #{"cljs.core/PersistentVector"
                                                    "cljs.core/PersistentArrayMap"
                                                    "cljs.core/PersistentHashSet"
                                                    "cljs.core/PersistentHashMap"
                                                    "cljs.core/Range"
                                                    "cljs.core/LazySeq"}

   ; -- pluggable markup ----------------------------------------------------------------------------------------------------

   :more-marker                                   "…"
   :body-items-more-label                         "more…"
   :string-abbreviation-marker                    " … "
   :multi-arity-symbol                            "…"
   :more-symbol                                   "…"
   :plus-symbol                                   "+"
   :header-field-value-spacer                     (span (css (str "color:" (named-color :field-spacer) ";")) "=")
   :body-field-value-spacer                       (span (css (str "color:" (named-color :field-spacer) ";")) "=")
   :header-field-separator                        " "
   :more-fields-symbol                            "…"
   :instance-value-separator                      ""
   :fields-header-open-symbol                     ""
   :fields-header-close-symbol                    ""
   :rest-symbol                                   " & "
   :args-open-symbol                              "["
   :args-close-symbol                             "]"
   :new-line-string-replacer                      "↵"
   :line-index-separator                          ""
   :dq                                            "\""
   :protocol-method-arities-more-symbol           "…"
   :protocol-method-arities-list-header-separator " "
   :spacer                                        " "
   :nil-label                                     "nil"
   :default-envelope-header                       "\uD83D\uDCE8"                                                              ; U+1F4E8: INCOMING ENVELOPE, http://www.charbase.com/1f4e8-unicode-incoming-envelope
   :list-separator                                " "
   :list-open-symbol                              ""
   :list-close-symbol                             ""

   ; -- backgrounds ---------------------------------------------------------------------------------------------------------

   :instance-custom-printing-background           (d/get-custom-printing-background-markup)
   :type-header-background                        (d/get-instance-type-header-background-markup)
   :native-reference-background                   (d/get-native-reference-background-markup)
   :protocol-background                           (d/get-protocol-background-markup)

   ; -- icons ---------------------------------------------------------------------------------------------------------------

   :basis-icon                                    (d/icon "β" (named-color :basis))
   :protocols-icon                                (d/icon "⊢" (named-color :protocol))
   :fields-icon                                   (d/icon "∋" (named-color :field))
   :method-icon                                   (d/icon "m" (named-color :method))
   :ns-icon                                       (d/icon "in" (named-color :ns))
   :native-icon                                   (d/icon "js" (named-color :native))
   :lambda-icon                                   (d/icon "λ" (named-color :lambda))
   :fn-icon                                       (d/icon "fn" (named-color :fn))
   :circular-ref-icon                             (d/icon "∞" (named-color :circular-ref) :slim)

   ; -- tags ----------------------------------------------------------------------------------------------------------------

   :cljs-land-tag                                 [:span :cljs-land-style]
   :header-tag                                    [:span :header-style]
   :item-tag                                      [:span :item-style]
   :nil-tag                                       [:span :nil-style]
   :bool-tag                                      [:span :bool-style]
   :keyword-tag                                   [:span :keyword-style]
   :symbol-tag                                    [:span :symbol-style]
   :integer-tag                                   [:span :integer-style]
   :float-tag                                     [:span :float-style]
   :string-tag                                    [:span :string-style]
   :expanded-string-tag                           [:span :expanded-string-style]
   :circular-reference-tag                        [:span :circular-reference-wrapper-style]
   :native-reference-tag                          [:span :native-reference-wrapper-style]
   :meta-wrapper-tag                              [:span :meta-wrapper-style]
   :meta-header-tag                               [:span :meta-style]
   :meta-body-tag                                 [:span :meta-body-style]
   :meta-reference-tag                            [:span :meta-reference-style]
   :body-tag                                      [:span :body-style]
   :index-tag                                     [:span :index-style]
   :standard-ol-tag                               [:ol :standard-ol-style]
   :standard-ol-no-margin-tag                     [:ol :standard-ol-no-margin-style]
   :standard-li-tag                               [:li :standard-li-style]
   :standard-li-no-margin-tag                     [:li :standard-li-no-margin-style]
   :aligned-li-tag                                [:li :aligned-li-style]
   :body-items-more-tag                           [:span :body-items-more-style]
   :fn-args-tag                                   [:span :fn-args-style]
   :fn-name-tag                                   [:span :fn-name-style]
   :fn-prefix-tag                                 [:span :fn-prefix-style]
   :fn-header-tag                                 [:span :fn-header-style]
   :fn-multi-arity-args-indent-tag                [:span :fn-multi-arity-args-indent-style]
   :fn-ns-name-tag                                [:span :fn-ns-name-style]
   :type-wrapper-tag                              [:span :type-wrapper-style]
   :type-name-tag                                 [:span :type-name-style]
   :type-ref-tag                                  [:span :type-ref-style]
   :type-basis-tag                                [:span :type-basis-style]
   :type-basis-item-tag                           [:span :type-basis-item-style]
   :standalone-type-tag                           [:span :standalone-type-style]
   :header-field-tag                              [:span :header-field-style]
   :header-field-name-tag                         [:span :header-field-name-style]
   :header-field-value-tag                        [:span :header-field-value-style]
   :instance-body-fields-table-tag                [:table :instance-body-fields-table-style]
   :body-field-tr-tag                             [:tr :body-field-tr-style]
   :body-field-td1-tag                            [:td :body-field-td1-style]
   :body-field-td2-tag                            [:td :body-field-td2-style]
   :body-field-name-tag                           [:span :body-field-name-style]
   :body-field-value-tag                          [:span :body-field-value-style]
   :fields-header-tag                             [:span :fields-header-style]
   :protocol-method-arities-header-tag            [:span :protocol-method-arities-header-style]
   :protocol-method-tag                           [:span :protocol-method-style]
   :protocol-method-name-tag                      [:span :protocol-method-name-style]
   :protocol-ns-name-tag                          [:span :protocol-ns-name-style]
   :protocols-header-tag                          [:span :protocols-header-style]
   :instance-value-tag                            [:span :instance-value-style]
   :instance-custom-printing-wrapper-tag          [:span :instance-custom-printing-wrapper-style]
   :instance-header-tag                           [:span :instance-header-style]
   :list-tag                                      [:span :list-style]
   :instance-custom-printing-tag                  [:span :instance-custom-printing-style]
   :default-envelope-tag                          [:span :default-envelope-style]

   ; -- DOM tags mapping ----------------------------------------------------------------------------------------------------

   :span                                          "span"
   :div                                           "div"
   :ol                                            "ol"
   :li                                            "li"
   :table                                         "table"
   :td                                            "td"
   :tr                                            "tr"

   ; -- styles --------------------------------------------------------------------------------------------------------------

   :cljs-land-style                               (css (str "background-color:" (named-color :signature-background) ";")
                                                       "border-radius: 2px;")

   :header-style                                  (css "white-space: nowrap;")                                                ; this prevents jumping of content when expanding sections due to content wrapping
   :item-style                                    (css "display: inline-block;"
                                                       "white-space: nowrap;"
                                                       "border-left: 2px solid rgba(100, 100, 100, 0.2);"
                                                       "padding: 0px 4px 0px 4px;"
                                                       "margin: 1px 0px 0px 0px;")

   :fn-header-style                               (css)
   :fn-prefix-style                               (css)
   :nil-style                                     (css (str "color: " (named-color :nil) ";"))
   :keyword-style                                 (css (str "color: " (named-color :keyword) ";"))
   :integer-style                                 (css (str "color: " (named-color :integer) ";"))
   :float-style                                   (css (str "color: " (named-color :float) ";"))
   :string-style                                  (css (str "color: " (named-color :string) ";"))
   :symbol-style                                  (css (str "color: " (named-color :symbol) ";"))
   :bool-style                                    (css (str "color: " (named-color :bool) ";"))

   :native-reference-wrapper-style                (css "display: inline-block;"                                               ; a hacky correction to hairy devtools tree-outline.css styles
                                                       "padding: 0px 3px;"
                                                       "position: relative;"
                                                       "margin-bottom: -3px;"
                                                       "top: -3px;")
   :type-wrapper-style                            (css "position: relative;"
                                                       "border-radius:2px;")
   :type-ref-style                                (css "position:relative;")
   :type-header-style                             (css (d/get-common-type-header-style)
                                                       "border-radius: 2px;")
   :type-name-style                               (css "padding-right: 4px;")
   :type-basis-style                              (css "margin-right:3px;")
   :type-basis-item-style                         (css (str "color: " (named-color :basis) ";")
                                                       "margin-right: 6px;")
   :protocol-name-style                           (css "position: relative;")
   :fast-protocol-style                           (css (d/get-common-protocol-style)
                                                       (str "color: " (named-color :fast-protocol) ";"))
   :slow-protocol-style                           (css (d/get-common-protocol-style)
                                                       (str "color: " (named-color :slow-protocol) ";"))
   :protocol-more-style                           (css "font-size: 8px;"
                                                       "position: relative;")
   :protocol-ns-name-style                        (css (str "color:" (named-color :ns) ";"))
   :list-style                                    (css)

   :body-field-td1-style                          (css "vertical-align: top;"
                                                       "padding:0;"
                                                       "padding-right: 4px;")
   :body-field-name-style                         (css (str "color:" (named-color :field) ";"))
   :body-field-value-style                        (css "margin-left: 6px;")
   :header-field-name-style                       (css (str "color:" (named-color :field) ";"))
   :body-field-td2-style                          (css "vertical-align: top;"
                                                       "padding:0;")
   :instance-header-style                         (css (d/type-outline-style))
   :standalone-type-style                         (css (d/type-outline-style))
   :instance-custom-printing-style                (css "position: relative;"
                                                       "padding: 0 2px 0 4px;")
   :instance-custom-printing-wrapper-style        (css "position: relative;"
                                                       "border-radius:2px;")
   :instance-type-header-style                    (css (d/get-common-type-header-style)
                                                       "border-radius: 2px 0 0 2px;")
   :instance-body-fields-table-style              (css "border-spacing: 0;"
                                                       "border-collapse: collapse;"
                                                       "margin-bottom: -2px;"                                                 ; weird spacing workaround
                                                       "display: inline-block;")
   :fields-header-style                           (css "padding: 0px 3px;")

   :protocol-method-name-style                    (css "margin-right: 6px;"
                                                       (str "color: " (named-color :protocol) " ;"))

   :meta-wrapper-style                            (css (str "border: 1px solid " (named-color :meta 0.4) ";")
                                                       "margin: -1px;"
                                                       "border-radius:2px;"
                                                       "display: inline-block;")
   :meta-style                                    (css (str "background-color:" (named-color :meta) ";")
                                                       "color:#eee;"
                                                       "border-radius: 0 1px 1px 0;"
                                                       "padding:0px 2px;"
                                                       "-webkit-user-select: none;")
   :meta-body-style                               (css (str "background-color: " (named-color :meta 0.1) ";")
                                                       "padding:1px;"
                                                       "padding-left: 14px;"
                                                       "border-bottom-right-radius:1x;")

   :fn-ns-name-style                              (css (str "color:" (named-color :ns) ";"))
   :fn-name-style                                 (css (str "color:" (named-color :fn) ";")
                                                       "margin-right:3px;")
   :fn-args-style                                 (css (str "color:" (named-color :fn) ";"))
   :fn-multi-arity-args-indent-style              (css "visibility:hidden;"
                                                       "padding-left: 1px;")
   :standard-ol-style                             (css "list-style-type:none;"
                                                       "padding-left:0px;"
                                                       "margin-top:0px;"
                                                       "margin-bottom:0px;"
                                                       "margin-left:0px;")
   :standard-ol-no-margin-style                   (css "list-style-type:none;"
                                                       "padding-left:0px;"
                                                       "margin-top:0px;"
                                                       "margin-bottom:0px;"
                                                       "margin-left:0px;")
   :standard-li-style                             (css "margin-left:0px;"
                                                       (d/get-body-line-common-style))
   :standard-li-no-margin-style                   (css "margin-left:0px;"
                                                       (d/get-body-line-common-style))
   :aligned-li-style                              (css "margin-left:0px;"
                                                       (d/get-body-line-common-style))

   :body-items-more-style                         (css (str "background-color:" (named-color :more-background) ";")
                                                       "min-width: 50px;"
                                                       "display: inline-block;"
                                                       (str "color: " (named-color :more) ";")
                                                       "cursor: pointer;"
                                                       "line-height: 14px;"
                                                       "font-size: 10px;"
                                                       "border-radius:2px;"
                                                       "padding: 0px 4px 0px 4px;"
                                                       "margin: 1px 0px 0px 0px;"
                                                       "-webkit-user-select: none;")
   :body-style                                    (css "display:inline-block;"
                                                       "padding: 3px 11px 3px 11px;"
                                                       (str "border-top: 1px solid " (named-color :body-border) ";")
                                                       "border-radius:1px;"
                                                       "margin: 1px;"
                                                       "margin-top: -1px;"
                                                       (str "background-color:" (named-color :signature-background) ";"))
   :index-style                                   (css "min-width: 50px;"
                                                       "display: inline-block;"
                                                       "text-align: right;"
                                                       "vertical-align: top;"
                                                       (str "background-color: " (named-color :index-background) ";")
                                                       (str "color:" (named-color :index) ";")
                                                       "opacity: 0.5;"
                                                       "margin-right: 3px;"
                                                       "padding: 0px 4px 0px 4px;"
                                                       "margin: 1px 0px 0px 0px;"
                                                       "-webkit-user-select: none;")
   :expanded-string-style                         (css "padding: 0px 12px 0px 12px;"
                                                       (str "color: " (named-color :string) ";")
                                                       "white-space: pre;"
                                                       (str "border-top: 1px solid " (named-color :expanded-string-border) ";")
                                                       "border-radius:1px;"
                                                       "margin: 0px 0px 2px 0px;"
                                                       (str "background-color:" (named-color :expanded-string-background) ";"))
   :default-envelope-style                        (css)

   ; -- pluggable api handlers ----------------------------------------------------------------------------------------------

   :header-pre-handler                            nil
   :header-post-handelr                           nil
   :has-body-pre-handler                          nil
   :has-body-post-handler                         nil
   :body-pre-handler                              nil
   :body-post-handler                             nil

   ; ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   })

