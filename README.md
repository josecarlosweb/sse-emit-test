## Demo de produção e consumo de Server Sent Events (SSE)

Para utilizar o consumidor:

```shell script
cd client
npm i
node index.js
```

A aplicação tem um endpoint GET /streaming que gera um  `text/event-stream` contendo um `keep alive`
a cada 10 segundos e uma lista de objetos gerados randomicamente a cada 20 segundos