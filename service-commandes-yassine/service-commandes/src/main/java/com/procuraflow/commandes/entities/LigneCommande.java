package com.procuraflow.commandes.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "lignes_commande", schema = "schema_commandes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LigneCommande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "designation", nullable = false)
    private String designation;

    @Column(name = "quantite", nullable = false)
    private int quantite;

    @Column(name = "prix_unitaire", nullable = false)
    private double prixUnitaire;

    @ManyToOne
    @JoinColumn(name = "commande_id")
    private Commande commande;
}