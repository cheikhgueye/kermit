package sn.dsi.kermit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.dsi.kermit.model.Image;


public interface ImageRepository  extends JpaRepository<Image, Long> {

}
