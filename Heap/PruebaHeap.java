import java.util.NoSuchElementException;

/**
 *
 * @author luis
 */
public class PruebaHeap {

    /**
     *
     * @return
     */
    public static double pruebaAgregar() {
        System.out.println("***************Prueba agregar ***************");
        try {
            MinHeap<Integer> min = new MinHeap();
            MaxHeap<Integer> max = new MaxHeap();
            
            min.agregar(7);
            min.agregar(4);
            min.agregar(9);
            min.agregar(6);
            min.agregar(5);
            min.agregar(3);
            min.agregar(8);
            min.agregar(2);
            min.agregar(1);
            
            max.agregar(7);
            max.agregar(4);
            max.agregar(9);
            max.agregar(6);
            max.agregar(5);
            max.agregar(3);
            max.agregar(8);
            max.agregar(2);
            max.agregar(1);
            
            
            

            String s1 = "[1, 2, 4, 3, 6, 9, 8, 7, 5]";
            String s2 = "[9, 6, 8, 4, 5, 3, 7, 2, 1]";

            System.out.println("Objetivo MinHeap:\n" + s1);
            System.out.println("Resultado MinHeap:\n" + min);
            
            System.out.println("Objetivo MaxHeap:\n" + s2);
            System.out.println("Resultado MaxHeap:\n" + max);
            int valor = 0;
            if (min.toString().equals(s1) && max.toString().equals(s2)) {
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
            MinHeap<Integer> min = new MinHeap();
            MaxHeap<Integer> max = new MaxHeap();
            
            min.agregar(7);
            min.agregar(4);
            min.agregar(9);
            min.agregar(6);
            min.agregar(5);
            min.agregar(3);
            min.agregar(8);
            min.agregar(2);
            min.agregar(1);
            
            max.agregar(7);
            max.agregar(4);
            max.agregar(9);
            max.agregar(6);
            max.agregar(5);
            max.agregar(3);
            max.agregar(8);
            max.agregar(2);
            max.agregar(1);

            String s1 = "[2, 3, 4, 5, 6, 9, 8, 7]";
            String s2 = "[8, 6, 7, 4, 5, 3, 1, 2]";
            System.out.println("MinHeap:\n" + min);
            System.out.println("Eliminando el tope:");
            min.eliminarTope();
            System.out.println("Objetivo MinHeap:\n" + s1);
            System.out.println("Resultado MinHeap:\n" + min);
            
            System.out.println("MaxHeap:\n" + max);
            System.out.println("Eliminando el tope:");
            max.eliminarTope();
            System.out.println("Objetivo MaxHeap:\n" + s2);
            System.out.println("Resultado MaxHeap:\n" + max);
            int valor = 0;
            if (min.toString().equals(s1) && max.toString().equals(s2)) {
                valor = 1;
                System.out.println("----Prueba existosa-----");
            } else {
                System.out.println("++++Prueba fallida++++");
            }

            System.out.println("***************Prueba eliminar ***************");

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
            MinHeap<Integer> min = new MinHeap();
            MaxHeap<Integer> max = new MaxHeap();
            
            min.agregar(7);
            min.agregar(4);
            min.agregar(9);
            min.agregar(6);
            min.agregar(5);
            min.agregar(3);
            min.agregar(8);
            min.agregar(2);
            min.agregar(1);
            
            max.agregar(7);
            max.agregar(4);
            max.agregar(9);
            max.agregar(6);
            max.agregar(5);
            max.agregar(3);
            max.agregar(8);
            max.agregar(2);
            max.agregar(1);
            
            System.out.println("MinHeap:\n" + min);
            System.out.println("Buscando al elemento 5:");
            System.out.println("Objetivo MinHeap:\n" + "true");
            System.out.println("Resultado MinHeap:\n" + min.contiene(5));
            
            System.out.println("MaxHeap:\n" + max);
            System.out.println("Buscando al elemento 10:");
            System.out.println("Objetivo MaxHeap:\n" + "false");
            System.out.println("Resultado MaxHeap:\n" + max.contiene(10));
            int valor = 0;
            if (min.contiene(5) && !max.contiene(10) ) {
                valor = 1;
                System.out.println("----Prueba existosa-----");
            } else {
                System.out.println("++++Prueba fallida++++");
            }

            System.out.println("***************Prueba Contiene ***************");

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
            MinHeap<Integer> min = new MinHeap();
            MaxHeap<Integer> max = new MaxHeap();
            
            min.agregar(7);
            min.agregar(4);
            min.agregar(9);
            min.agregar(6);
            min.agregar(5);
            min.agregar(3);
            min.agregar(8);
            min.agregar(2);
            min.agregar(1);
            
            max.agregar(7);
            max.agregar(4);
            max.agregar(9);
            max.agregar(6);
            max.agregar(5);
            max.agregar(3);
            max.agregar(8);
            max.agregar(2);
            max.agregar(1);
            
            String s1 = "[";
            String s2 = "[";
            
            for(Integer elem:min){
                s1 += elem + " ";
            }
            s1+="]";
            
            for(Integer elem:max){
                s2 += elem + " ";
            }
            s2+="]";
            
            String s3 = "[1 2 4 3 6 9 8 7 5 ]";
            String s4 = "[9 6 8 4 5 3 7 2 1 ]";
            
            System.out.println("MinHeap:\n" + min);
            System.out.println("Usando el ciclo for each");
            System.out.println("Objetivo MinHeap:\n" + s3);
            System.out.println("Resultado MinHeap:\n" + s1);
            
            System.out.println("MaxHeap:\n" + max);
            System.out.println("Buscando al elemento 10:");
            System.out.println("Objetivo MaxHeap:\n" + s4);
            System.out.println("Resultado MaxHeap:\n" + s2);
            int valor = 0;
            if (s3.equals(s1) && s4.equals(s2) ) {
                valor = 1;
                System.out.println("----Prueba existosa-----");
            } else {
                System.out.println("++++Prueba fallida++++");
            }

            System.out.println("***************Prueba iterador ***************");

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
            MinHeap<Integer> min = new MinHeap();
            MaxHeap<Integer> max = new MaxHeap();
            
            boolean r1 = min.esVacia();
            boolean r2 = max.esVacia();
            
            System.out.println("MinHeap:\n" + min);
            System.out.println("Objetivo MinHeap:\n" + "true");
            System.out.println("Resultado MinHeap:\n" + r1);
            
            System.out.println("MaxHeap:\n" + max);
            System.out.println("Objetivo MaxHeap:\n" + "true");
            System.out.println("Resultado MaxHeap:\n" + r2);
            
            min.agregar(7);
            min.agregar(4);
            min.agregar(9);
            min.agregar(6);
            min.agregar(5);
            min.agregar(3);
            min.agregar(8);
            min.agregar(2);
            min.agregar(1);
            
            max.agregar(7);
            max.agregar(4);
            max.agregar(9);
            max.agregar(6);
            max.agregar(5);
            max.agregar(3);
            max.agregar(8);
            max.agregar(2);
            max.agregar(1);
            
            System.out.println("MinHeap:\n" + min);
            System.out.println("Objetivo MinHeap:\n" + "false");
            System.out.println("Resultado MinHeap:\n" + min.esVacia());
            
            System.out.println("MaxHeap:\n" + max);
            System.out.println("Objetivo MaxHeap:\n" + "false");
            System.out.println("Resultado MaxHeap:\n" + max.esVacia());

            
            int valor = 0;
            if (r1 && r2 && !min.esVacia() && !max.esVacia()) {
                valor = 1;
                System.out.println("----Prueba existosa-----");
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
    public static double pruebaGetTamanio() {

        System.out.println("**************Prueba getTamanio**************");
        try {
            MinHeap<Integer> min = new MinHeap();
            MaxHeap<Integer> max = new MaxHeap();
            
            int r1 = min.getTamanio();
            int r2 = max.getTamanio();
            
            System.out.println("MinHeap:\n" + min);
            System.out.println("Objetivo MinHeap:\n" + "0");
            System.out.println("Resultado MinHeap:\n" + min.getTamanio());
            
            System.out.println("MaxHeap:\n" + max);
            System.out.println("Objetivo MaxHeap:\n" + "0");
            System.out.println("Resultado MaxHeap:\n" + max.getTamanio());
            
            min.agregar(7);
            min.agregar(4);
            min.agregar(9);
            min.agregar(6);
            min.agregar(5);
            min.agregar(3);
            min.agregar(8);
            min.agregar(2);
            min.agregar(1);
            
            max.agregar(7);
            max.agregar(4);
            max.agregar(9);
            max.agregar(6);
            max.agregar(5);
            max.agregar(3);
            max.agregar(8);
            max.agregar(2);
            max.agregar(1);
            
            System.out.println("MinHeap:\n" + min);
            System.out.println("Objetivo MinHeap:\n" + "9");
            System.out.println("Resultado MinHeap:\n" + min.getTamanio());
            
            System.out.println("MaxHeap:\n" + max);
            System.out.println("Objetivo MaxHeap:\n" + "9");
            System.out.println("Resultado MaxHeap:\n" + max.getTamanio());

            
            int valor = 0;
            if (r1 == 0 && r2 == 0 && min.getTamanio() == 9 && max.getTamanio() == 9) {
                valor = 1;
                System.out.println("----Prueba existosa-----");
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
            MinHeap<Integer> min1 = new MinHeap();
            MinHeap<Integer> min2 = new MinHeap();
            

            
            min1.agregar(7);
            min1.agregar(4);
            min1.agregar(9);
            min1.agregar(6);
            min1.agregar(5);
            min1.agregar(3);
            min1.agregar(8);
            min1.agregar(2);
            min1.agregar(1);
            
            min2.agregar(7);
            min2.agregar(4);
            min2.agregar(9);
            min2.agregar(6);
            min2.agregar(5);
            min2.agregar(3);
            min2.agregar(8);
            min2.agregar(2);
            min2.agregar(1);
            
            System.out.println("MinHeap 1:\n" + min1);
            System.out.println("MinHeap 2:\n" + min2);
            System.out.println("Objetivo:\n" + "true");
            System.out.println("Resultado:\n" + min1.equals(min2));
            boolean b = min1.equals(min2);
            min1.eliminarTope();
            System.out.println("MinHeap 1:\n" + min1);
            System.out.println("MinHeap 2:\n" + min2);
            System.out.println("Objetivo:\n" + "false");
            System.out.println("Resultado:\n" + min1.equals(min2));
            int valor = 0;
            if (b && !min1.equals(min2)) {
                valor = 1;
                System.out.println("----Prueba existosa-----");
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



    public static void main(String[] args) {
        
        double calificacion = 0;
        
        

        calificacion += pruebaAgregar();
        calificacion += pruebaEliminar();
        calificacion += pruebaContiene();
        calificacion += pruebaIterador();
        calificacion += pruebaEsVacia();
        calificacion += pruebaGetTamanio();
        calificacion += pruebaEquals();
        System.out.println("Calificacion: " + calificacion);
    }
}

