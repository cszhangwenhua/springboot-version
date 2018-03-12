package contracts

import org.springframework.cloud.contract.spec.Contract

/**
 * Created by Administrator on 2018/3/9.
 */
Contract.make {
    request {
        method 'GET'
        url '/person/one'
        headers {
            contentType('application/json')
        }
    }
    response {
        status 200
        body("""{
            "id": "${value("1000")}"
       }""")
        headers {
            contentType(applicationJson())
        }
    }
}

