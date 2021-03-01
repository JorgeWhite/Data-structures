
import java.util.NoSuchElementException;

/**
 *
 * @author luis
 */
public class PruebaArbolOrdenado {

    /**
     *
     * @return
     */
    public static double pruebaAgregar() {
        System.out.println("***************Prueba agregar ***************");
        try {

            ArbolBinarioBusqueda<Integer> arbol = new ArbolBinarioBusqueda<>();
            arbol.agregar(5);
            arbol.agregar(2);
            arbol.agregar(1);
            arbol.agregar(3);
            arbol.agregar(12);
            arbol.agregar(9);
            arbol.agregar(10);
            arbol.agregar(11);
            arbol.agregar(9);
            arbol.agregar(7);
            arbol.agregar(8);
            arbol.agregar(7);
            arbol.agregar(6);

            String s = "5\n"
                    + "├─›2\n"
                    + "│  ├─›1\n"
                    + "│  └─»3\n"
                    + "└─»12\n"
                    + "   └─›9\n"
                    + "      ├─›7\n"
                    + "      │  ├─›6\n"
                    + "      │  └─»8\n"
                    + "      │     └─›7\n"
                    + "      └─»10\n"
                    + "         ├─›9\n"
                    + "         └─»11\n";

            System.out.println("Objetivo:\n" + s);
            System.out.println("Resultado:\n" + arbol);
            int valor = 0;
            if (arbol.toString().equals(s)) {
                valor = 1;
                System.out.println("----Prueba existosa-----");
            } else {
                System.out.println("++++Prueba fallida++++");
            }

            System.out.println("***************Prueba agregar ***************");

            return valor;

        } catch (Exception e) {
            System.out.println("--------------------Error--------------------");
            System.out.println(e);
            System.out.println("--------------------Error--------------------");
            return 0;
        }
    }

    /**
     *
     * @return
     */
    public static double pruebaEliminar() {
        System.out.println("***************Prueba eliminar***************");
        try {
            int valor = 0;
            ArbolBinarioBusqueda<Integer> arbol = new ArbolBinarioBusqueda<>();
            arbol.agregar(5);
            arbol.agregar(2);
            arbol.agregar(1);
            arbol.agregar(3);
            arbol.agregar(12);
            arbol.agregar(9);
            arbol.agregar(10);
            arbol.agregar(11);
            arbol.agregar(9);
            arbol.agregar(7);
            arbol.agregar(8);
            arbol.agregar(7);
            arbol.agregar(6);
            System.out.println("Arbol:\n" + arbol);
            System.out.println("Elemento eliminado:" + 12);
            arbol.eliminar(12);
            String s = "5\n"
                    + "├─›2\n"
                    + "│  ├─›1\n"
                    + "│  └─»3\n"
                    + "└─»9\n"
                    + "   ├─›7\n"
                    + "   │  ├─›6\n"
                    + "   │  └─»8\n"
                    + "   │     └─›7\n"
                    + "   └─»10\n"
                    + "      ├─›9\n"
                    + "      └─»11\n";

            System.out.println("Objetivo:\n" + s);
            System.out.println("Resultado:\n" + arbol);
            if (s.equals(arbol.toString())) {
                System.out.println("Elemento eliminado:" + 9);
                arbol.eliminar(9);
                s = "5\n"
                        + "├─›2\n"
                        + "│  ├─›1\n"
                        + "│  └─»3\n"
                        + "└─»8\n"
                        + "   ├─›7\n"
                        + "   │  ├─›6\n"
                        + "   │  └─»7\n"
                        + "   └─»10\n"
                        + "      ├─›9\n"
                        + "      └─»11\n";
                System.out.println("Objetivo:\n" + s);
                System.out.println("Resultado:\n" + arbol);

                if (s.equals(arbol.toString())) {
                    System.out.println("Elemento eliminado:" + 9);
                    arbol.eliminar(9);
                    s = "5\n"
                            + "├─›2\n"
                            + "│  ├─›1\n"
                            + "│  └─»3\n"
                            + "└─»8\n"
                            + "   ├─›7\n"
                            + "   │  ├─›6\n"
                            + "   │  └─»7\n"
                            + "   └─»10\n"
                            + "      └─»11\n";

                    System.out.println("Objetivo:\n" + s);
                    System.out.println("Resultado:\n" + arbol);
                    if (s.equals(arbol.toString())) {
                        System.out.println("----Prueba existosa-----");
                        valor = 1;
                    } else {
                        System.out.println("++++Prueba fallida++++");
                    }
                } else {
                    System.out.println("++++Prueba fallida++++");
                }

            } else {
                System.out.println("++++Prueba fallida++++");
            }

            System.out.println("***************Prueba eliminar***************");

            return valor;

        } catch (Exception e) {
            System.out.println("--------------------Error--------------------");
            System.out.println(e);
            System.out.println("--------------------Error--------------------");
            return 0;
        }
    }

    /**
     *
     * @return
     */
    public static double pruebaContiene() {
        System.out.println("***************Prueba Contiene***************");
        try {
            ArbolBinarioBusqueda<Integer> arbol = new ArbolBinarioBusqueda<>();
            arbol.agregar(5);
            arbol.agregar(2);
            arbol.agregar(1);
            arbol.agregar(3);
            arbol.agregar(12);
            arbol.agregar(9);
            arbol.agregar(10);
            arbol.agregar(11);
            arbol.agregar(9);
            arbol.agregar(7);
            arbol.agregar(8);
            arbol.agregar(7);
            arbol.agregar(6);

            System.out.println("Arbol:\n" + arbol);
            System.out.println("Buscamos al elemento 10:");
            System.out.println("Objetivo:  " + "true");
            System.out.println("Resultado: " + arbol.contiene(10));
            System.out.println("Buscamos al elemento 6:");
            System.out.println("Objetivo:  " + "true");
            System.out.println("Resultado: " + arbol.contiene(6));

            System.out.println("Buscamos al elemento 4:");
            System.out.println("Objetivo:  " + "false");
            System.out.println("Resultado: " + arbol.contiene(4));
            double valor = 0;
            if (arbol.contiene(10) && arbol.contiene(6) && !arbol.contiene(4)) {
                valor = 1;
                System.out.println("----Prueba existosa-----");
            } else {
                valor = 0;
                System.out.println("++++Prueba fallida++++");
            }

            System.out.println("***************Prueba Contiene***************");

            return valor;

        } catch (Exception e) {
            System.out.println("--------------------Error--------------------");
            System.out.println(e);
            System.out.println("--------------------Error--------------------");
            return 0;
        }
    }

    /**
     *
     * @return
     */
    public static double pruebaIterador() {
        System.out.println("***************Prueba Iterador***************");
        try {
            ArbolBinarioBusqueda<Integer> arbol = new ArbolBinarioBusqueda<>();
            arbol.agregar(5);
            arbol.agregar(2);
            arbol.agregar(1);
            arbol.agregar(3);
            arbol.agregar(12);
            arbol.agregar(9);
            arbol.agregar(10);
            arbol.agregar(11);
            arbol.agregar(9);
            arbol.agregar(7);
            arbol.agregar(8);
            arbol.agregar(7);
            arbol.agregar(6);
            Cola<Integer> cola = new Cola<>();
            for (Integer elemento : arbol) {
                cola.queue(elemento);
            }
            String s = "[1,2,3,5,6,7,7,8,9,9,10,11,12]";
            System.out.println("Arbol:\n" + arbol);
            System.out.println("Cola con los elementos del arbol usando for each para agregar:\n");
            System.out.println("Objetivo: " + s);
            System.out.println("Resultado: " + cola);

            double valor = 0;
            if (s.equals(cola.toString())) {
                valor = 1;
                System.out.println("----Prueba existosa-----");
            } else {
                valor = 0;
                System.out.println("++++Prueba fallida++++");
            }
            System.out.println("***************Prueba Iterador***************");

            return valor;

        } catch (Exception e) {
            System.out.println("--------------------Error--------------------");
            System.out.println(e);
            System.out.println("--------------------Error--------------------");
            return 0;
        }
    }

    /**
     *
     * @return
     */
    public static double pruebaConstructorIterable() {
        System.out.println("***************Prueba Constructor Iterable***************");
        try {

            Cola<Integer> cola = new Cola<>();
            cola.queue(5);
            cola.queue(2);
            cola.queue(1);
            cola.queue(3);
            cola.queue(12);
            cola.queue(9);
            cola.queue(10);
            cola.queue(11);
            cola.queue(9);
            cola.queue(7);
            cola.queue(8);
            cola.queue(7);
            cola.queue(6);

            ArbolBinarioBusqueda<Integer> arbol = new ArbolBinarioBusqueda<>((Coleccionable<Integer>) cola);

            String s = "5\n"
                    + "├─›2\n"
                    + "│  ├─›1\n"
                    + "│  └─»3\n"
                    + "└─»12\n"
                    + "   └─›9\n"
                    + "      ├─›7\n"
                    + "      │  ├─›6\n"
                    + "      │  └─»8\n"
                    + "      │     └─›7\n"
                    + "      └─»10\n"
                    + "         ├─›9\n"
                    + "         └─»11\n";
            System.out.println("Objetivo:\n" + s);
            System.out.println("Resultado:\n " + arbol);

            double valor = 0;
            if (s.equals(arbol.toString())) {
                valor = 1;
                System.out.println("----Prueba existosa-----");
            } else {
                valor = 0;
                System.out.println("++++Prueba fallida++++");
            }
            System.out.println("***************Prueba Constructor Iterable***************");

            return valor;

        } catch (Exception e) {
            System.out.println("--------------------Error--------------------");
            System.out.println(e);
            System.out.println("--------------------Error--------------------");
            return 0;
        }
    }

    /**
     *
     * @return
     */
    public static double pruebaEsVacia() {

        System.out.println("***************Prueba es Vacia***************");
        try {
            int valor = 0;
            ArbolBinarioBusqueda<Integer> arbol = new ArbolBinarioBusqueda<>();
            arbol.agregar(11);
            Lista<String> lista = new Lista();
            boolean v1 = true;
            System.out.println("Arbol:\n " + arbol);
            System.out.println("Objetivo:    " + "false");
            System.out.println("Resultado:   " + arbol.esVacia());
            if (!arbol.esVacia()) {
                arbol.eliminar(11);
                System.out.println("Arbol:\n " + arbol);
                System.out.println("Objetivo:    " + "true");
                System.out.println("Resultado:   " + arbol.esVacia());
                if (arbol.esVacia()) {
                    valor = 1;
                    System.out.println("----Prueba existosa-----");
                } else {
                    System.out.println("++++Prueba fallida++++");
                }

            } else {
                System.out.println("++++Prueba fallida++++");
            }

            System.out.println("***************Prueba es Vacia***************");

            return valor;

        } catch (Exception e) {
            System.out.println("--------------------Error--------------------");
            System.out.println(e);
            System.out.println("--------------------Error--------------------");
            return 0;
        }
    }

    /**
     *
     * @return
     */
    public static double pruebaVaciar() {

        System.out.println("****************Prueba vaciar****************");
        try {
            int valor = 0;
            ArbolBinarioBusqueda<Integer> arbol = new ArbolBinarioBusqueda<>();
            arbol.agregar(5);
            arbol.agregar(2);
            arbol.agregar(1);
            arbol.agregar(3);
            arbol.agregar(12);
            arbol.agregar(9);
            arbol.agregar(10);
            arbol.agregar(11);
            arbol.agregar(9);
            arbol.agregar(7);
            arbol.agregar(8);
            arbol.agregar(7);
            arbol.agregar(6);

            String s = "5\n"
                    + "├─›2\n"
                    + "│  ├─›1\n"
                    + "│  └─»3\n"
                    + "└─»12\n"
                    + "   └─›9\n"
                    + "      ├─›7\n"
                    + "      │  ├─›6\n"
                    + "      │  └─»8\n"
                    + "      │     └─›7\n"
                    + "      └─»10\n"
                    + "         ├─›9\n"
                    + "         └─»11\n";

            System.out.println("Arbol:\n" + arbol);
            arbol.vaciar();
            System.out.println("Objetivo: " + "");
            System.out.println("Resultado:" + arbol);

            if (arbol.getTamanio() == 0 && arbol.toString().equals("")) {
                valor = 1;
                System.out.println("----Prueba existosa-----");
            } else {
                System.out.println("++++Prueba fallida++++");
            }

            System.out.println("****************Prueba vaciar****************");

            return valor;

        } catch (Exception e) {
            System.out.println("--------------------Error--------------------");
            System.out.println(e);
            System.out.println("--------------------Error--------------------");
            return 0;
        }
    }

    /**
     *
     * @return
     */
    public static double pruebaGetTamanio() {

        System.out.println("**************Prueba getTamanio**************");
        try {

            int valor = 0;
            ArbolBinarioBusqueda<Integer> arbol = new ArbolBinarioBusqueda<>();
            arbol.agregar(5);
            arbol.agregar(2);
            arbol.agregar(1);
            arbol.agregar(3);
            arbol.agregar(12);
            arbol.agregar(9);
            arbol.agregar(10);
            arbol.agregar(11);
            arbol.agregar(9);
            arbol.agregar(7);
            arbol.agregar(8);
            arbol.agregar(7);
            arbol.agregar(6);

            String s = "5\n"
                    + "├─›2\n"
                    + "│  ├─›1\n"
                    + "│  └─»3\n"
                    + "└─»12\n"
                    + "   └─›9\n"
                    + "      ├─›7\n"
                    + "      │  ├─›6\n"
                    + "      │  └─»8\n"
                    + "      │     └─›7\n"
                    + "      └─»10\n"
                    + "         ├─›9\n"
                    + "         └─»11\n";

            System.out.println("Arbol:\n" + arbol);
            System.out.println("Objetivo: " + 13);
            System.out.println("Resultado:" + arbol.getTamanio());

            if (arbol.getTamanio() == 13) {
                arbol.eliminar(12);
                System.out.println("Arbol despues de eliminar al 12:\n" + arbol);
                System.out.println("Objetivo: " + 12);
                System.out.println("Resultado:" + arbol.getTamanio());
                if (arbol.getTamanio() == 12) {
                    valor = 1;
                    System.out.println("----Prueba existosa-----");
                } else {
                    System.out.println("++++Prueba fallida++++");
                }

            } else {
                System.out.println("++++Prueba fallida++++");
            }

            System.out.println("**************Prueba getTamanio**************");

            return valor;

        } catch (Exception e) {
            System.out.println("--------------------Error--------------------");
            System.out.println(e);
            System.out.println("--------------------Error--------------------");
            return 0;
        }
    }

    /**
     *
     * @return
     */
    public static double pruebaEquals() {

        System.out.println("****************Prueba equals*****************");
        try {
            int valor = 0;
            ArbolBinarioBusqueda<Integer> arbol = new ArbolBinarioBusqueda<>();
            arbol.agregar(5);
            arbol.agregar(2);
            arbol.agregar(1);
            arbol.agregar(3);
            arbol.agregar(12);
            arbol.agregar(9);
            arbol.agregar(10);
            arbol.agregar(11);
            arbol.agregar(9);
            arbol.agregar(7);
            arbol.agregar(8);
            arbol.agregar(7);
            arbol.agregar(6);

            ArbolBinarioBusqueda<Integer> arbol2 = new ArbolBinarioBusqueda<>();
            arbol2.agregar(5);
            arbol2.agregar(2);
            arbol2.agregar(1);
            arbol2.agregar(3);
            arbol2.agregar(12);
            arbol2.agregar(9);
            arbol2.agregar(10);
            arbol2.agregar(11);
            arbol2.agregar(9);
            arbol2.agregar(7);
            arbol2.agregar(8);
            arbol2.agregar(7);
            arbol2.agregar(6);

            System.out.println("Arbol 1:\n" + arbol);
            System.out.println("Arbol 2:\n" + arbol2);
            System.out.println("Objetivo: " + "true");
            System.out.println("Resultado:" + arbol.equals(arbol2));

            if (arbol.equals(arbol2)) {
                arbol.eliminar(12);
                System.out.println("Arbol 1 despues de eliminar al 12:\n" + arbol);
                System.out.println("Arbol 2:\n" + arbol2);
                System.out.println("Objetivo: " + "false");
                System.out.println("Resultado:" + arbol.equals(arbol2));
                if (!arbol.equals(arbol2)) {
                    valor = 1;
                    System.out.println("----Prueba existosa-----");
                } else {
                    System.out.println("++++Prueba fallida++++");
                }

            } else {
                System.out.println("++++Prueba fallida++++");
            }

            System.out.println("****************Prueba equals*****************");

            return valor;

        } catch (IllegalArgumentException | NoSuchElementException e) {
            System.out.println("--------------------Error--------------------");
            System.out.println(e);
            System.out.println("--------------------Error--------------------");
            return 0;
        }
    }

    /**
     *
     * @return
     */
    public static double pruebaInOrden() {
        System.out.println("***************Prueba InOrden ***************");
        try {

            ArbolBinarioBusqueda<Integer> arbol = new ArbolBinarioBusqueda<>();
            arbol.agregar(5);
            arbol.agregar(2);
            arbol.agregar(1);
            arbol.agregar(3);
            arbol.agregar(12);
            arbol.agregar(9);
            arbol.agregar(10);
            arbol.agregar(11);
            arbol.agregar(9);
            arbol.agregar(7);
            arbol.agregar(8);
            arbol.agregar(7);
            arbol.agregar(6);

            String s = "[1,2,3,5,6,7,7,8,9,9,10,11,12]";

            System.out.println("Objetivo:\n" + s);
            System.out.println("Resultado:\n" + arbol.inOrden());
            int valor = 0;
            if (s.equals(arbol.inOrden().toString())) {
                valor = 1;
                System.out.println("----Prueba existosa-----");
            } else {
                System.out.println("++++Prueba fallida++++");
            }

            System.out.println("***************Prueba InOrden ***************");

            return valor;

        } catch (Exception e) {
            System.out.println("--------------------Error--------------------");
            System.out.println(e);
            System.out.println("--------------------Error--------------------");
            return 0;
        }
    }

    /**
     *
     * @return
     */
    public static double pruebaPreOrden() {
        System.out.println("***************Prueba PreOrden ***************");
        try {

            ArbolBinarioBusqueda<Integer> arbol = new ArbolBinarioBusqueda<>();
            arbol.agregar(5);
            arbol.agregar(2);
            arbol.agregar(1);
            arbol.agregar(3);
            arbol.agregar(12);
            arbol.agregar(9);
            arbol.agregar(10);
            arbol.agregar(11);
            arbol.agregar(9);
            arbol.agregar(7);
            arbol.agregar(8);
            arbol.agregar(7);
            arbol.agregar(6);

            String s = "[5,2,1,3,12,9,7,6,8,7,10,9,11]";

            System.out.println("Objetivo:\n" + s);
            System.out.println("Resultado:\n" + arbol.preOrden());
            int valor = 0;
            if (s.equals(arbol.preOrden().toString())) {
                valor = 1;
                System.out.println("----Prueba existosa-----");
            } else {
                System.out.println("++++Prueba fallida++++");
            }

            System.out.println("***************Prueba PreOrden ***************");

            return valor;

        } catch (Exception e) {
            System.out.println("--------------------Error--------------------");
            System.out.println(e);
            System.out.println("--------------------Error--------------------");
            return 0;
        }
    }

    /**
     *
     * @return
     */
    public static double pruebaPostOrden() {
        System.out.println("***************Prueba PreOrden ***************");
        try {

            ArbolBinarioBusqueda<Integer> arbol = new ArbolBinarioBusqueda<>();
            arbol.agregar(5);
            arbol.agregar(2);
            arbol.agregar(1);
            arbol.agregar(3);
            arbol.agregar(12);
            arbol.agregar(9);
            arbol.agregar(10);
            arbol.agregar(11);
            arbol.agregar(9);
            arbol.agregar(7);
            arbol.agregar(8);
            arbol.agregar(7);
            arbol.agregar(6);

            String s = "[1,3,2,6,7,8,7,9,11,10,9,12,5]";

            System.out.println("Objetivo:\n" + s);
            System.out.println("Resultado:\n" + arbol.postOrden());
            int valor = 0;
            if (s.equals(arbol.postOrden().toString())) {
                valor = 1;
                System.out.println("----Prueba existosa-----");
            } else {
                System.out.println("++++Prueba fallida++++");
            }

            System.out.println("***************Prueba PreOrden ***************");

            return valor;

        } catch (Exception e) {
            System.out.println("--------------------Error--------------------");
            System.out.println(e);
            System.out.println("--------------------Error--------------------");
            return 0;
        }
    }

    /**
     *
     * @return
     */
    public static double pruebaRotacionIzquierda() {
        System.out.println("***************Prueba rotacion izquierda ***************");
        try {

            ArbolBinarioBusqueda<Integer> arbol = new ArbolBinarioBusqueda<>();
            arbol.agregar(5);
            arbol.agregar(2);
            arbol.agregar(1);
            arbol.agregar(3);
            arbol.agregar(12);
            arbol.agregar(9);
            arbol.agregar(10);
            arbol.agregar(11);
            arbol.agregar(9);
            arbol.agregar(7);
            arbol.agregar(8);
            arbol.agregar(7);
            arbol.agregar(6);

            System.out.println("Arbol:\n" + arbol);

            String s = "5\n"
                    + "├─›2\n"
                    + "│  ├─›1\n"
                    + "│  └─»3\n"
                    + "└─»12\n"
                    + "   └─›9\n"
                    + "      ├─›7\n"
                    + "      │  ├─›6\n"
                    + "      │  └─»8\n"
                    + "      │     └─›7\n"
                    + "      └─»10\n"
                    + "         ├─›9\n"
                    + "         └─»11\n";
            arbol.pruebaRotacionIzquierda(12);
            System.out.println("Rotamos a la izquierda a 12");
            System.out.println("Objetivo:\n" + s);
            System.out.println("Resultado:\n" + arbol);
            int valor = 0;

            if (arbol.toString().equals(s)) {

                arbol.pruebaRotacionIzquierda(5);

                s = "12\n"
                        + "└─›5\n"
                        + "   ├─›2\n"
                        + "   │  ├─›1\n"
                        + "   │  └─»3\n"
                        + "   └─»9\n"
                        + "      ├─›7\n"
                        + "      │  ├─›6\n"
                        + "      │  └─»8\n"
                        + "      │     └─›7\n"
                        + "      └─»10\n"
                        + "         ├─›9\n"
                        + "         └─»11\n";
                System.out.println("Rotamos a la izquierda a 5");
                System.out.println("Objetivo:\n" + s);
                System.out.println("Resultado:\n" + arbol);

                if (arbol.toString().equals(s)) {
                    valor = 1;
                    System.out.println("----Prueba existosa-----");
                } else {
                    System.out.println("++++Prueba fallida++++");
                }

            } else {
                System.out.println("++++Prueba fallida++++");
            }

            System.out.println("***************Prueba rotacion izquierda ***************");

            return valor;

        } catch (Exception e) {
            System.out.println("--------------------Error--------------------");
            System.out.println(e);
            System.out.println("--------------------Error--------------------");
            return 0;
        }
    }

    /**
     *
     * @return
     */
    public static double pruebaRotacionDerecha() {
        System.out.println("***************Prueba rotacion derecha ***************");
        try {

            ArbolBinarioBusqueda<Integer> arbol = new ArbolBinarioBusqueda<>();
            arbol.agregar(5);
            arbol.agregar(2);
            arbol.agregar(1);
            arbol.agregar(3);
            arbol.agregar(12);
            arbol.agregar(9);
            arbol.agregar(10);
            arbol.agregar(11);
            arbol.agregar(9);
            arbol.agregar(7);
            arbol.agregar(8);
            arbol.agregar(7);
            arbol.agregar(6);

            System.out.println("Arbol:\n" + arbol);

            String s = "5\n"
                    + "├─›2\n"
                    + "│  ├─›1\n"
                    + "│  └─»3\n"
                    + "└─»9\n"
                    + "   ├─›7\n"
                    + "   │  ├─›6\n"
                    + "   │  └─»8\n"
                    + "   │     └─›7\n"
                    + "   └─»12\n"
                    + "      └─›10\n"
                    + "         ├─›9\n"
                    + "         └─»11\n";
            arbol.pruebaRotacionDerecha(12);
            System.out.println("Rotamos a la derecha a 12");
            System.out.println("Objetivo:\n" + s);
            System.out.println("Resultado:\n" + arbol);
            int valor = 0;
            if (arbol.toString().equals(s)) {

                arbol.pruebaRotacionDerecha(3);
                System.out.println("Rotamos a la derecha a 3");
                System.out.println("Objetivo:\n" + s);
                System.out.println("Resultado:\n" + arbol);
                if (arbol.toString().equals(s)) {
                    valor = 1;
                    System.out.println("----Prueba existosa-----");
                } else {
                    System.out.println("++++Prueba fallida++++");
                }

            } else {
                System.out.println("++++Prueba fallida++++");
            }

            System.out.println("***************Prueba rotacion derecha ***************");

            return valor;

        } catch (Exception e) {
            System.out.println("--------------------Error--------------------");
            System.out.println(e);
            System.out.println("--------------------Error--------------------");
            return 0;
        }
    }

    public static void main(String[] args) {

        double calificacion = 0;

        calificacion += pruebaAgregar();
        calificacion += pruebaEliminar();
        calificacion += pruebaContiene();
        calificacion += pruebaIterador();
        calificacion += pruebaConstructorIterable();
        calificacion += pruebaEsVacia();
        calificacion += pruebaGetTamanio();
        calificacion += pruebaVaciar();
        calificacion += pruebaEquals();
        calificacion += pruebaInOrden();
        calificacion += pruebaPreOrden();
        calificacion += pruebaPostOrden();
        calificacion += pruebaPostOrden();
        calificacion += pruebaRotacionDerecha();
        calificacion += pruebaRotacionIzquierda();
        
        System.out.println("Calificacion: " + calificacion);

    }


}

