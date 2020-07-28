import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private int sesion;

    public Main() {
        this.sesion = 3;
    }
    public void decrementSesion() throws Exception{
        if(this.sesion > 0){
            this.sesion -= 1;
        }
        else {
            throw new Exception("Su Sesión ha caducado, gracias por utilizar nuestros servicios");
        }


    }

    public int getSesion() {
        return sesion;
    }
    public static void main(String[] args) throws Exception {
        Main sesion = new Main();
        Transaccion transaccion = new Transaccion();

        while (sesion.getSesion() > 0){
            System.out.println("Bienvenido a Banco Azul, selecciona operación a realizar: \n"
                            + "1 Depósito \n"
                            + "2 Retiro \n"
                            + "3 Ver transacciones \n"
                            + "4 Cerrar sesión\n "
                    + "--------------------------------");

            Scanner opcion = new Scanner(System.in);
            try {
                int opcion_1 = opcion.nextInt();
                if(transaccion.getOperaciones() == 0){
                    System.out.println("Su sesión alcanzó el maximo de transacciones, para iniciar una nueva sesión presione 1");
                    Scanner confirmacion = new Scanner(System.in);
                    int value = confirmacion.nextInt();
                    if(value == 1){
                        transaccion = new Transaccion();
                        sesion.decrementSesion();
                    }else{
                        System.out.println("Gracias por usar nuestra plataforma \n");
                        return;
                    }

                }
                else if(opcion_1 == 1){
                    System.out.println("Ingrese Monto a depositar y moneda, formato (Currency, Amount)\n");
                    Scanner curr = new Scanner(System.in);
                    String value = curr.nextLine();
                    transaccion.depositarSaldo(value);
                    System.out.println("Depósito exitoso \n");

                }else if (opcion_1 == 2){
                    System.out.println("Ingrese Monto a retirar y moneda, formato (Currency, Amount)\n");
                    Scanner curr = new Scanner(System.in);
                    String value = curr.nextLine();
                    transaccion.retirarSaldo(value);
                    System.out.println("Retiro exitoso \n");

                }else if (opcion_1 == 3){
                    List<String> Historial = transaccion.getHistorial();
                    System.out.println("Ultimas 3 transacciones:\n");
                    for (String elemento: Historial) {
                        System.out.println("[" + elemento + "]"+ "\n");

                    }

                }else if (opcion_1 == 4){
                    System.out.println("Se ha cerrado la sesión, para volver a iniciar sesión presione \"1\"\n");
                    Scanner confirmacion = new Scanner(System.in);
                    int value = confirmacion.nextInt();
                    if(value == 1){
                        transaccion = new Transaccion();
                    }else{
                        System.out.println("Gracias por usar nuestra plataforma \n");
                        return;
                    }

                }
            }catch (Exception e){
                System.out.println(e.getMessage() + "\n");
            }




        }
        System.out.println("Ha alcanzado el maximo de sesiones posibles, gracias por utilizar nuestros servicios.");
    }

}
