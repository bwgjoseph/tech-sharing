package com.armyc3.overlay.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Overlay {

	@Id
	private String id;
	private String name;
	private String workspaceId;
	
}