package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Device;

import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;


public interface DeviceRepository extends DatastoreRepository<Device, Long> {

  List<Device> findByMacAdress(String macAdress);

  Optional<Device> findById(Long id);

  void deleteById(Long id);


}