function fn() {
  var config = {
    baseUrl: 'http://localhost:3000' // URL de tu API local
  };

    // Configuración de los logs
  karate.configure('logPrettyRequest', false); // Para mostrar el cuerpo de la solicitud en formato bonito
  karate.configure('logPrettyResponse', false); // Para mostrar el cuerpo de la respuesta en formato bonito
  karate.configure('printEnabled', true); // Habilitar impresión en la consola

  return config;
}
