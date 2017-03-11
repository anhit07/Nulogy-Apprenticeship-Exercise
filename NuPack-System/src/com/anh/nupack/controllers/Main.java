package com.anh.nupack.controllers;

public class Main {

	public static void main(String[] args) {

		try {
			PackingService packing = new PackingService();
			System.out.println(packing.doPackingService(args[0], args[1],
					args[2], args[3]));
		} catch (RuntimeException ex) {
			System.out
					.println("Please input following information:\nProduct name, product material, product base price and the number of people on packing job");
			System.exit(0);
		}
	}

}
