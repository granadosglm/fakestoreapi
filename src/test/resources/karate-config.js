function fn() {
  var config = {
//    baseUrl: 'https://z6lgn4iqje.execute-api.us-east-1.amazonaws.com/dev', // URL api publica
    baseUrl: 'https://ycaa57jmnj.execute-api.us-east-1.amazonaws.com:1443/dev'
  };

    // Configuración de los logs
  karate.configure('logPrettyRequest', false); // Para mostrar el cuerpo de la solicitud en formato bonito
  karate.configure('logPrettyResponse', false); // Para mostrar el cuerpo de la respuesta en formato bonito
  karate.configure('printEnabled', true); // Habilitar impresión en la consola

  config.apiKey = 'B5c3I2hBeg3q3HexmRQ3P5DvmQL1zUFSopcHBFY4';
  config.contentType = 'application/json';

  return config;
}
