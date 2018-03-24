package contracts.hello

import org.springframework.cloud.contract.spec.Contract

/**
 * Created by Administrator on 2018/3/9.
 */
Contract.make {
    description("""
Represents a successful scenario of getting a beer

```
given:
	client is old enough
when:
	he applies for a beer
then:
	we'll grant him the beer
```

""")
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
