package com.anh.nupack.controllers;


public class Main {

	public static void main(String[] args) {

		try {
			String response = "Please enter following information:\n";
			boolean invalid = false;
			if (args == null || args.length == 0) {
				response = response
						+ "(Product name, product material, product base price, and number of people on packing job)";
				invalid = true;
			}
			if (args.length == 1) {
				response = response
						+ "(Product material, product base price, the number of people on packing job)";
				invalid = true;
			}
			if (args.length == 2) {
				response = response
						+ "(product base price, the number of people on packing job)";
				invalid = true;
			}
			if (args.length == 3) {
				response = response + "(Number of people on packing job)";
				invalid = true;
			}
			
			if (args.length > 4) {
				response = "So many arguments";
				invalid = true;
			}
			if (invalid) {
				System.out.println(response);
				System.exit(0);
			} else {
				PackingService packing = new PackingService();
				packing.doPackingService(args[0], args[1],args[2], args[3]);
			}
		} catch (RuntimeException ex) {
			ex.printStackTrace();
		}
	}
}
