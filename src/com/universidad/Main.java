package com.universidad;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.Area;
import com.entities.Material;
import com.entities.Salon;
import com.exceptions.ServiciosException;
import com.servicios.AreasBeanRemote;
import com.servicios.MaterialesBeanRemote;
import com.servicios.SalonesBeanRemote;

public class Main {

	public static void main(String[] args) throws NamingException {
		AreasBeanRemote areasBean = (AreasBeanRemote) InitialContext
				.doLookup("UniversidadEJB/AreasBean!com.servicios.AreasBeanRemote");

		MaterialesBeanRemote materialesBean = (MaterialesBeanRemote) InitialContext
				.doLookup("UniversidadEJB/MaterialesBean!com.servicios.MaterialesBeanRemote");

		SalonesBeanRemote salonesBean = (SalonesBeanRemote) InitialContext
				.doLookup("UniversidadEJB/SalonesBean!com.servicios.SalonesBeanRemote");

		// Creo las areas
		Area area1 = new Area();
		area1.setNombre("LTI");
		try {
			area1.setId(areasBean.crear(area1));
			System.out.println(
					"Se ha dado de alta el área " + area1.getNombre() + " y su clave principal es " + area1.getId());
		} catch (ServiciosException e) {
			System.out.println("Error al crear el área.");
		}

		Area area2 = new Area();
		area2.setNombre("BIOMEDICAS");
		try {
			area2.setId(areasBean.crear(area2));
			System.out.println(
					"Se ha dado de alta el área " + area2.getNombre() + " y su clave principal es " + area2.getId());
		} catch (ServiciosException e) {
			System.out.println("Error al crear el área.");
		}

		Area area3 = new Area();
		area3.setNombre("IAGRO");
		try {
			area3.setId(areasBean.crear(area3));
			System.out.println(
					"Se ha dado de alta el área " + area3.getNombre() + " y su clave principal es " + area3.getId());
		} catch (ServiciosException e) {
			System.out.println("Error al crear el área.");
		}

		// Creo los salones del area LTI
		Salon salon1 = new Salon();
		salon1.setNombre("ROBOTICA");
		// salon1.setArea(area1);
		try {
			salon1.setId(salonesBean.crear(salon1));
			System.out.println(
					"Se ha dado de alta el salón " + salon1.getNombre() + " y su clave principal es " + salon1.getId());
		} catch (ServiciosException e) {
			System.out.println("Error al crear el salón.");
		}

		Salon salon2 = new Salon();
		salon2.setNombre("AULA DE CLASES 3");
		// salon2.setArea(area1);
		try {
			salon2.setId(salonesBean.crear(salon2));
			System.out.println(
					"Se ha dado de alta el salón " + salon2.getNombre() + " y su clave principal es " + salon2.getId());
		} catch (ServiciosException e) {
			System.out.println("Error al crear el salón.");
		}

		Salon salon3 = new Salon();
		salon3.setNombre("SALA DE SERVIDORES");
		// salon3.setArea(area1);
		try {
			salon3.setId(salonesBean.crear(salon3));
			System.out.println(
					"Se ha dado de alta el salón " + salon3.getNombre() + " y su clave principal es " + salon3.getId());
		} catch (ServiciosException e) {
			System.out.println("Error al crear el salón.");
		}

		// Creo los materiales del salon ROBOTICA
		Material material1 = new Material();
		material1.setNombre("PLACA ARDUINO");
		try {
			material1.setId(materialesBean.crear(material1));
			System.out.println("Se ha dado de alta el material " + material1.getNombre() + " y su clve principal es "
					+ material1.getId());
		} catch (ServiciosException e) {
			System.out.println("Error al crear el material.");
		}

		Material material2 = new Material();
		material2.setNombre("IMPRESORA 3D");
		try {
			material2.setId(materialesBean.crear(material2));
			System.out.println("Se ha dado de alta el material " + material2.getNombre() + " y su clave principal es "
					+ material2.getId());
		} catch (ServiciosException e) {
			System.out.println("Error al crear el material.");
		}

		// Le asigno los materiales
		try {
			salonesBean.asignarMaterial(salon1.getId(), material1.getId());

		} catch (ServiciosException e1) {
			System.out.println("No se pudo asignar el material al salón.");
		}

		try {
			salonesBean.asignarMaterial(salon1.getId(), material2.getId());
		} catch (ServiciosException e1) {
			System.out.println("No se pudo asignar el material al salón.");
		}

		// Le asigno areas a los salones
		try {
			salonesBean.asignarArea(salon1.getId(), area1.getId());
		} catch (ServiciosException e) {
			System.out.println("No se pudo asignar el área al salón.");
		}

	}

}
