package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Device;
import com.example.demo.service.DeviceService;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
public class DeviceController {

	private DeviceService service;

	@Autowired
	public DeviceController(DeviceService service) {
		this.service = service;
	}

	@GetMapping("/")
	  public String hello() {
	    return "hello world!";
	  }
	
	
	
	@PostMapping("/add")
	public void addDevice(@RequestBody DeviceContext device ) throws ParseException {
		service.addDevice(device);
	}

	@PostMapping("/test")
	public void addDevice() {
		System.out.println("test post");
	}

	@GetMapping("/getDevices")
	public String getDevices() {
		System.out.println("get devices");
		return service.getDevices().toString();
		 
	}

	@GetMapping("/getDeviceByMacAdress")
	public String getByMacAdress(@RequestParam String macAdress) {
		return service.getByMacAdress(macAdress).toString();
	}
	
	@GetMapping("/getDeviceById")
	public String getById(@RequestParam Long id) {
		return service.getById(id).toString();
	}

	@GetMapping("/crosscheck")
	public String crosscheck(@RequestParam String id) {
		return "crosscheck done!" + id;
	}
	
	@DeleteMapping("/deleteDevice")
	public void deleteDevice(@RequestBody Long id) {
		service.deleteDeviceById(id);
	}
}