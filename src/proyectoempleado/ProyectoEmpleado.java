/*
 * 04/03/2021
 * Copyright 2020-2021 Canlas Company
 * Ramón y Cajal 6, Humanes de Madrid, 28970, Madrid, España
 * Todos los derechos reservados.
 */
package proyectoempleado;

import java.util.ArrayList;

import java.util.Scanner;

/**
 * @author Canlas
 */
public class ProyectoEmpleado {

    /**
     * @param args the command line arguments
     */
    public static void cargarDatosIniciales(ArrayList<Empleado> empleados){
        String[] datosIniciales = {
                "aitor tilla informática 60000",
                "alba ñoguarro r.humanos 40000",
                "ester colero logística 34000",
                "andRés trozado informática 56000",
                "armAndo ruido logística 39000",
                "dolores fuertes r.humanos 45000",
                "enrique cide r.humanos 48000",
                "estela gartija logística 52000",
                "josechu leton informática 49000",
                "lola mento informática 51000"};

        String [] datos;
        String nombre;
        String apellido;
        String departamento;
        Integer salario;
        int contador = 0;

        for (String persona : datosIniciales) {
            datos = persona.split(" ");

            for (int i = 0; i < datos.length; i++) {
                nombre = datos[i];
                apellido = datos[i+1];
                departamento = datos[i+2];
                salario = Integer.parseInt(datos[i+3]);
                i+=3;

                Empleado empleado = new Empleado(nombre, apellido, departamento, salario);
                empleados.add(empleado);
                contador++;
            }
        }
    }

    public static void mostrarEmpleados(ArrayList<Empleado> empleados){
        for (Empleado empleado : empleados){
            empleado.mostrarEmpleado();
        }
        System.out.println();
    }

    public static void mostrarMenu(){
        System.out.println("1. Mostrar empleados");
        System.out.println("2. Dar alta nuevo empleado");
        System.out.println("3. Buscar empleado por nombre");
        System.out.println("4. Buscar empleado por departamento");
        System.out.println("5. Borrar empleado");
        System.out.println("6. Buscar empleado por sueldo");
        System.out.println("7. Subir sueldo");
        System.out.println("8. Salir");
    }

    public static int pedirOpcionMenu(int opcion){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Por favor, seleccione una de las siguientes opciones\n");
        opcion = teclado.nextInt();
        System.out.println();
        return opcion;
    }

    public static void altaNuevoEmpleado(ArrayList<Empleado> empleados){
        Scanner tecladoString = new Scanner(System.in);
        Scanner tecladoInteger = new Scanner(System.in);
        String nombre;
        String apellido;
        String departamento;
        Integer salario;

        System.out.println("Por favor, introduzca el nombre del nuevo empleado");
        nombre = tecladoString.nextLine();

        System.out.println("Introduzca el apellido");
        apellido = tecladoString.nextLine();

        System.out.println("Introduzca el departamento");
        departamento = tecladoString.nextLine();

        System.out.println("Por último, introduzca el salario");
        salario = tecladoInteger.nextInt();

        Empleado empleado = new Empleado(nombre, apellido, departamento, salario);
        empleados.add(empleado);
        System.out.println("Ha añadido con éxito un nuevo empleado\n");
        System.out.println();
    }

    public static void buscarEmpleadoNombre(ArrayList<Empleado> empleados){
        Scanner teclado = new Scanner(System.in);
        String nombre = "";
        System.out.println("Por favor introduzca el nombre del empleado a buscar");
        nombre = teclado.nextLine();

        for (Empleado empleado : empleados){
            if (empleado.getNombre().equalsIgnoreCase(nombre)){
                System.out.println("Los datos del empleado son: ");
                empleado.mostrarEmpleado();
            }
        }
        System.out.println();
    }

    public static void buscarEmpleadoDepartamento(ArrayList<Empleado> empleados){
        Scanner teclado = new Scanner(System.in);
        String departamento;
        System.out.println("Por favor, introduzca el nombre del departamento al que pertenecen los empleados que desea visualizar");
        departamento = teclado.nextLine();

        for (Empleado empleado : empleados){
            if (empleado.getDepartamento().equalsIgnoreCase(departamento)){
                empleado.mostrarEmpleado();
            }
        }
        System.out.println();
    }

    public static void borrarEmpleado(ArrayList<Empleado> empleados){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca el nombre del empleado que desea borrar");
        String nombre = teclado.nextLine();

        empleados.removeIf(empleado -> empleado.getNombre().equalsIgnoreCase(nombre));
        System.out.println("El empleado ha sido borrado con éxito\n");
    }

    public static void buscarEmpleadoSegunSueldo(ArrayList<Empleado> empleados){
        Scanner teclado = new Scanner(System.in);
        int intervalo1 = 0;
        int intervalo2 = 0;

        System.out.println("Introduzca un intervalo entre 20.000 y 60.000 €");
        System.out.println("Introduzca el primer intervalo");
        intervalo1 = teclado.nextInt();
        while (intervalo1 < 20000 || intervalo1 > 60000){
            System.out.println("Intervalo fuera de rango. Por favor introduzca un intervalo entre 20.000 y 60.000 €");
            intervalo1 = teclado.nextInt();
            System.out.println();
        }
        System.out.println("Ahora introduzca el segundo intervalo");
        intervalo2 = teclado.nextInt();
        System.out.println();
        while (intervalo1 >= intervalo2){
            System.out.println("Importe del intervalo 1 es superior al intervalo 2. Por favor seleccione un intervalo superior");
            intervalo2 = teclado.nextInt();
            System.out.println();
            while (intervalo2 > 60000){
                System.out.println("Intervalo fuera de rango. Por favor introduzca un intervalo inferior a 60.000 €");
                intervalo2 = teclado.nextInt();
                System.out.println();
            }
        }
        for (Empleado empleado : empleados){
            if (empleado.getSalario() >= intervalo1 && empleado.getSalario() <= 60000){
                System.out.println("El empleado que corresponde a este salario es ");
                empleado.mostrarEmpleado();
                System.out.println();
            }
        }
    }

    public static void subirSueldo(ArrayList<Empleado> empleados){
        Scanner teclado = new Scanner(System.in);
        Scanner teclado1 = new Scanner(System.in);
        String nombre = "";
        float porcentaje = 0;

        System.out.println("Por favor introduzca el nombre del empleado al que va a subir el sueldo");
        nombre = teclado.nextLine();
        System.out.println("Ahora introduzca el porcentaje a aplicar en la subida de sueldo");
        porcentaje = teclado1.nextFloat();

        for (int i = 0; i < empleados.size(); i++){
            if (empleados.get(i).getNombre().equalsIgnoreCase(nombre)){
                empleados.get(i).subirSalario(porcentaje);
                System.out.println("El nuevo salario es " + empleados.get(i).getSalario());
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
         ArrayList<Empleado> empleados = new ArrayList<>();
        int opcion = 0;
        boolean salir = false;

        cargarDatosIniciales(empleados);

        do {
            mostrarMenu();
            opcion = pedirOpcionMenu(opcion);
            switch (opcion){
                case 1: mostrarEmpleados(empleados); break;
                case 2: altaNuevoEmpleado(empleados); break;
                case 3: buscarEmpleadoNombre(empleados); break;
                case 4: buscarEmpleadoDepartamento(empleados); break;
                case 5: borrarEmpleado(empleados); break;
                case 6: buscarEmpleadoSegunSueldo(empleados); break;
                case 7: subirSueldo(empleados); break;
                case 8:
                    System.out.println("Gracias por usar nuestro programa");salir = true; break;
                default:
                    System.out.println("Opción no válida");;
            }
        } while (!salir);
    }
    
}
