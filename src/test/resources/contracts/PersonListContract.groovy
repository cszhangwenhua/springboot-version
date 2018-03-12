package contracts

import org.springframework.cloud.contract.spec.Contract

/**
 * Created by Administrator on 2018/3/12.
 */
Contract.make {
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
}