package contracts.person

import org.springframework.cloud.contract.spec.Contract

/**
 * Created by Administrator on 2018/3/20.
 */
[
        Contract.make {
            name("person")
            request {
                method 'GET'
                url value(consumer(regex('/person/[1-9][0-9]{4}')))
                headers {
                    contentType('application/json')
                }
            }
            response {
                status 200
                body("""{
            "id": "${producer(regex('[0-9]{5}'))}",
            "createTime": "${value(regex(number()))}",
            "headUrl": "${value((regex(url())))}"
       }""")
                headers {
                    contentType(applicationJson())
                }
            }
        },

        Contract.make {
            name("person_list")
            request {
                method 'GET'
                url '/person/list'
                headers {
                    contentType('application/json')
                }
            }
            response {
                status 200
                headers {
                    contentType(applicationJson())
                }
            }
        },
        Contract.make {
            name("person_queryParameters")
            request {
                method 'GET'
                url('/person') {
                    queryParameters {
                        parameter 'id': value(regex('[1-9][0-9]{4}'))
                    }
                }
                headers {
                    contentType('application/json')
                }

            }
            response {
                status 200
                body("""{
                 "id": "${value(regex('[0-9]{5}'))}",
                 "name": "${value(regex('zhang [0-9]{5}'))}"
       }""")
                headers {
                    contentType(applicationJson())
                }
            }
        },
        Contract.make {
            request {
                name("person_mixParameters")
                method 'GET'
                url(value(consumer(regex('/person/goods/[1-9][0-9]{4}'))))
                        {
                            queryParameters {
                                parameter 'goodsId': value(regex('[1-9][0-9]{4}'))
                            }
                        }
                headers {
                    contentType('application/json')
                }

            }
            response {
                status 200
                body("""{
            "id": "${value(regex('[0-9]{5}'))}",
            "name": "${value(regex('Goods[0-9]{5}'))}",
            "owner":{
                "id": "${value(regex('[0-9]{5}'))}",
                "name": "${value(regex('zhang [0-9]{5}'))}"
            }

                }""")
                headers {
                    contentType(applicationJson())
                }
            }
        }
]
