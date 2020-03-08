package com.example.demo.repository;


import com.example.demo.entity.FlexiCaptureStatusPk;
import com.example.demo.entity.FlexiCaputreStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlexiCaputreStatusRepository extends JpaRepository<FlexiCaputreStatus, FlexiCaptureStatusPk> {

}
