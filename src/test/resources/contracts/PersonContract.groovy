package contracts

import org.springframework.cloud.contract.spec.Contract

/**
 * Created by Administrator on 2018/3/9.
 */
Contract.make {
    request {
        method 'GET'
        url value(consumer(regex('/person/[0-9]{5}')))
        headers {
            contentType('application/json')
        }
    }
    response {
        status 200
        body("""{
            "id": "${producer(regex('[0-9]{5}'))}"
       }""")
        headers {
            contentType(applicationJson())
        }
    }
}

