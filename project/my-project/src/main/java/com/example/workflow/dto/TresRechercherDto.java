package com.example.workflow.dto;

public class TresRechercherDto {
    private Boolean tresRechercher;

    public TresRechercherDto(boolean tresRechercher) {
        this.tresRechercher = tresRechercher;
    }
    public TresRechercherDto() {
    }

    public boolean isTresRechercher() {
        return tresRechercher;
    }


}
