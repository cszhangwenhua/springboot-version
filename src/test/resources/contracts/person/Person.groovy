package contracts.person

import org.springframework.cloud.contract.spec.Contract

/**
 * Created by Administrator on 2018/3/20.
 */
[
        Contract.make {
            name("consumer_producer_use")
            request {
                method 'GET'
                url('/person') {
                    queryParameters {
                        parameter 'id': value(consumer(regex('[1-9][0-9]{4}')))
                        parameter 'offset': value(consumer(matching("[0-9]+")), producer("123"))
                    }
                }
                headers {
                    contentType('application/json')
                }

            }
            response {
                status 200
                body(
                        id: $(fromRequest().query('id')),
                        name: value(regex('zhang [0-9]{5}'))
                )
                headers {
                    contentType(applicationJson())
                }
            }
        },
        Contract.make {
            name("json_path")
            request {
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
                body(
                        id: value(regex('[0-9]{5}')),
                        name: value(regex('Goods[0-9]{5}')),
                        owner: [
                                id  : value(regex('[0-9]{5}')),
                                name: value(regex('zhang [0-9]{5}'))
                        ]
                )
                headers {
                    contentType(applicationJson())
                }
            }
        }
]
