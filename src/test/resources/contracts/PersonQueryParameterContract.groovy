package contracts

import org.springframework.cloud.contract.spec.Contract

/**
 * Created by Administrator on 2018/3/9.
 */
Contract.make {
    request {
        method 'GET'
        url('/person') {
            queryParameters {
                parameter 'id': value(regex('[0-9]{5}'))
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
}

