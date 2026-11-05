package com.procuraflow.commandes.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "commandes", schema = "schema_commandes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fournisseur_id", nullable = false)
    private Long fournisseurId;

    @Column(name = "date_commande")
    private LocalDateTime dateCommande;

    @Enumerated(EnumType.STRING)
    @Column(name = "statut")
    private StatutCommande statut;

    @Column(name = "montant_total", nullable = false)
    private Double montantTotal;

    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LigneCommande> lignesCommande;
}