import java.util.Scanner;

public class Sprint8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int totalClientes = 0;
        boolean introducirMasDatos = true;

        while (introducirMasDatos) {
            // ID
            int id_cliente = obtenerDatoValido("Introduce tu ID (111-999): ", 111, 999);

            // Edad
            int edad = obtenerDatoValido("Introduce tu edad (14-120): ", 14, 120);

            // Tipo de venta
            int tipo_venta = obtenerDatoValido(
                    "Tipo de venta: Venta Lliure (0), Pensionista (1), Carnet Jove (2), Soci (3): ", 0, 3);

            // Importe
            int importe = obtenerDatoValido("Introduce el importe (0-1000): ", 0, 1000);

            // Número de teléfono
            int tel = obtenerDatoValido("Introduce tu número de teléfono (9 dígitos): ", 100000000, 999999999);

            // Tipo de venta a texto
            String tipoVentaTexto = "";
            switch (tipo_venta) {
                case 0:
                    tipoVentaTexto = "Lliure";
                    break;
                case 1:
                    tipoVentaTexto = "Pensionista";
                    break;
                case 2:
                    tipoVentaTexto = "Carnet Jove";
                    break;
                case 3:
                    tipoVentaTexto = "Soci";
                    break;
            }

            // Mostrar los datos del cliente
            System.out.println("Datos del cliente:");
            System.out.println("Id: " + id_cliente);
            System.out.println("Edat: " + edad);
            System.out.println("Tipus de venda: " + tipoVentaTexto);
            System.out.println("Import: " + importe);
            System.out.println("Telèfon: " + tel);

            // Preguntar si se quiere introducir otro cliente
            System.out.print("¿Quieres introducir más datos? (Sí = 1, No = 0): ");
            int respuesta = input.nextInt();
            if (respuesta == 0) {
                introducirMasDatos = false;
            }

            totalClientes++; // Incrementar el número de clientes introducidos
        }

        // Mostrar el número total de clientes introducidos
        System.out.println("S'han introduït " + totalClientes + " clients.");
        input.close();
    }

    // Método para obtener un dato válido con un máximo de 3 intentos
    public static int obtenerDatoValido(String mensaje, int min, int max) {
        Scanner input = new Scanner(System.in);
        int dato;
        int intentos = 0;
        while (true) {
            System.out.print(mensaje);
            dato = input.nextInt();
            if (dato >= min && dato <= max) {
                return dato;
            } else {
                intentos++;
                if (intentos == 3) {
                    System.out.println("Número máximo de intentos alcanzado. Finalizando.");
                    System.exit(0); // Termina el programa al alcanzar los tres intentos
                }
                System.out.println("Dato no válido. Intenta de nuevo.");
            }
        }
    }
}
