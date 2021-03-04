/*
 * 04/03/2021
 * Copyright 2020-2021 Canlas Company
 * Ramón y Cajal 6, Humanes de Madrid, 28970, Madrid, España
 * Todos los derechos reservados.
 */
package proyectoempleado;

import java.text.DecimalFormat;

import java.util.Locale;

/**
 * La clase empleado incorpora cuatro atributos: nombre, apellido, departamento y salario
 * @author Canlas
 */
public class Empleado {
    //Atributos
    private String nombre;
    private String apellido;
    private String departamento;
    private Integer salario;

    /**
     * Argumentos del constructor
     * @param nombre
     * @param apellido
     * @param departamento
     * @param salario 
     */
    public Empleado(String nombre, String apellido, String departamento, Integer salario){
        //Constructor
        this.nombre = nombre;
        this.apellido = apellido;
        this.departamento = departamento;
        this.salario = salario;
    }

    /**
     * 
     * @param nombre
     * @param apellido 
     */
    public Empleado(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    /** 
     * Método para obtener nombre de Empleado
     * @return 
     */
    public String getNombre(){
        return this.nombre.substring(0,1).toUpperCase(Locale.ROOT) + this.nombre.substring(1);
    }

    /**
     * Método para obtener apellido de empleado
     * @return 
     */
    public String getApellido(){
        return this.apellido.substring(0,1).toUpperCase(Locale.ROOT) + this.apellido.substring(1);
    }
    
    /**
     * Método para obtener departamento de empleado
     * @return 
     */
    public String getDepartamento(){
        return this.departamento.substring(0,1).toUpperCase(Locale.ROOT) + this.departamento.substring(1);
    }

    /**
     * Método para obtener salario de empleado
     * @return 
     */
    public float getSalario(){
        return this.salario;
    }

    /**
     * Método para pintar por pantalla los objetos que se crean de la clase empleado
     */
    public void mostrarEmpleado(){
        DecimalFormat salarioConDecimales = new DecimalFormat();
        System.out.println(this.nombre.substring(0,1).toUpperCase(Locale.ROOT) + this.nombre.substring(1) + " " + this.apellido.substring(0,1).toUpperCase(Locale.ROOT) + this.apellido.substring(1) + " " + this.departamento.substring(0,1).toUpperCase(Locale.ROOT) + this.departamento.substring(1) + " " + salarioConDecimales.format(this.salario) + " €");
    }

    /** 
     * Método para comparar si una instancia de empleado es igual a otra instancia previamente creada
     * @param objeto
     * @return 
     */
    public boolean equals (Object objeto){
        if (objeto instanceof Empleado){
            Empleado nuevoEmpleado = (Empleado) objeto;
            if (this.nombre.equalsIgnoreCase(nuevoEmpleado.nombre)){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Método para calcular en base a un porcentaje dado, la subida del salario aplicando el porcentaje
     * @param porcentaje 
     */
    public void subirSalario(float porcentaje){
        float resultado = this.salario * porcentaje;
        resultado = resultado / 100;
        resultado += this.salario;
        this.salario = (int)(resultado);
    }
}
