. Diferencia entre Runnable y Thread
  Runnable es una interfaz que tiene el método run() que tenemos que sobreescribir, por eso implementamos runnable permitiéndonos la herencia de otra clase.
  Thread es una clase que hay que heredar.

. Ciclo de vida de un Thread
  Un thread comienza con el método start() que llama al método run() pasando por los estados de corriendo o no y muere al finalizar al dejar de ejecutarse el método run(). 

. Explique los métodos:

  - start: Start() inicia el hilo llamando al método run();
  
  - sleep: Sleep() pone a dormir un thread por el tiempo especificado
  
  - yield: Yield() mueve a un thread al final de la cola de threads
  
  - join: Join() pone a un thread a la espera de la ejecucion del métod run()
