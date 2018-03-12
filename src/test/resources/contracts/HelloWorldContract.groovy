package contracts

import org.springframework.cloud.contract.spec.Contract

/**
 * Created by Administrator on 2018/3/9.
 */
Contract.make {
    request {
        method 'GET'
        url '/hello'
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
}
