# AdminPedidos
Evaluación técnica para empresa de software.

En el presente proyecto, no solo se realizó lo pedido en el enunciado, sino que trato de establecer una arquitectura en particular que se comentará a continuación y se agregaron algunos tests mínimos usando junit.


## Arquitectura

La arquitectura utilizada es una arquitectura de capas (Layers), algo similar a lo que se vé en la imagen.
![layers](https://github.com/gfibrizo/adminpedidos/tree/master/recursos/layers.gif)

De esta manera, las capas pueden evolucionar independientemente una de la otra. 


La capa de negocio solo tiene cosas propias del dominio del problema y logica de negocio, y es independiente de cualquier framework que se pudiera usar en otra capa. Esta capa no conoce a ninguna otra por lo que no tiene ninguna dependencia hacia las demas.


La capa de datos expone permite cambiar las fuentes de datos (base de datos y cache) de manera sencilla, y de esta manera poder testear la logica de persistencia y consulta a dichas fuentes de datos tambien de manera simple por medio de la implementación de mocks.


La capa de presentación tiene una clase Inicializador que se encarga de instanciar las clases concretas de la capa de datos (las clases que se comunicaran contra los repositorios, o sea contra las BDs y caches). Esto esta hecho de esta manera para aislar y concentrar en un solo lugar la creación de clases concretas y no generar acoplamiento con dichas clases en otros lados. Además, se hace en la capa de presentación ya que es una capa de la periferia y no del centro (Core) de la aplicación.

Se puede ver en la siguiente imagen un ejemplo este concepto de periferia y centro de una aplicación. Si bien hay algunas cosas de más en la imagen, el concepto se puede apreciar.


![arquitectura limpia](https://github.com/gfibrizo/adminpedidos/tree/master/resources/clean1.png)


## Tests con JUnit

Se armaron algunos tests simples en JUnit. La clase testeada es la clase Repositorio, que tiene la lógica de control de acceso a la base de datos y a la cache, a traves de PedidosDAO y BumexMemcached. 
Para realizar los tests, se realizaron clases Mock que simulan el acceso a una BD y a la cache, y reemplazan a PedidosDAO y BumexMemcached en la clase Repositorio. Estas clases Mock implementan interfaces que a su vez tambien implementan PedidosDAO y BumexMemcached respectivamente.


## Hipótesis tomadas

- La clase PedidosDao es un Data Mapper. Devuelve objetos del dominio (Pedido) y se comunica con una determinado repositorio (base de datos relacional en este caso).

- La clase BumexMemcached realizar operaciones contra una Cache, y en este caso, es usada para ahorrar operaciones que de otra manera se realizarian contra la base de datos.


## Observaciones al enunciado

- Los nombres de variables, funciones, entidades y campos de la base de datos estan en idiomas diferentes. Deberían estar en el mismo idioma.

- La clase BumexMemcached no cumple con la convencion usada. Deberia ser BumexMemCached

- El nombre de la clase BumexMemcached no es lo suficientemente explicativo.

- La clase BumexMemcached no dice si sus métodos son estaticos o de instancia. Se asumió que eran estáticos para estar en concordancia con la clase PedidosDAO.

- El método delete de PedidoDAO no tiene sentido que reciba una instancia de Pedido, deberia recibir un String o un int que sea el id.

- Los ids no deben ser Strings, sino ints si se trata del mismo id que el campo idPedido de la entidad Pedido de la base de datos.


