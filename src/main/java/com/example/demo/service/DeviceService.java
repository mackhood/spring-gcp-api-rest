package com.example.demo.service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.google.common.collect.Lists;
import com.example.demo.controller.DeviceContext;
import com.example.demo.model.Device;
import com.example.demo.repository.DeviceRepository;

@Service
public class DeviceService {
	private DeviceRepository deviceRepository;

	@Autowired
	public DeviceService(DeviceRepository deviceRepository) {
		this.deviceRepository = deviceRepository;
	}

	public String addDevice(DeviceContext deviceContext) throws ParseException {
		SimpleDateFormat objSDF = new SimpleDateFormat("dd-mm-yyyy",Locale.ENGLISH); 
		
		Device device = new Device(deviceContext.getMacAdress(),objSDF.parse(deviceContext.getTimestamp()));
		
		if(device.isCorrect()) {
		deviceRepository.save(device);
		return "Succesful saving device";
		}
		else {
		return "wrong params of device";
		}
			
	}
	
	public void deleteDevice(Device device) {
		deviceRepository.delete(device);
	}
	

	public ArrayList<Device> getDevices() {
		Iterable<Device> deviceList = deviceRepository.findAll();
		return Lists.newArrayList(deviceList);
	}

	public Iterable<Device> getByMacAdress(String macAdress) {
		Iterable<Device> device = deviceRepository.findByMacAdress(macAdress);
		return device;
	}
	
	public Optional<Device> getById(Long id) {
		Optional<Device> device = deviceRepository.findById(id);
		return device;
	}

	public void deleteDeviceById(Long id) {
		deviceRepository.deleteById(id);
		
	}
}
