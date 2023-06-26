package com.tocura.study.kotlin.adapter.database

import com.tocura.study.kotlin.adapter.database.entity.PokemonEntity
import com.tocura.study.kotlin.adapter.database.entity.PokemonTrainerEntity
import com.tocura.study.kotlin.core.model.PokemonTrainer
import com.tocura.study.kotlin.core.ports.Database
import org.springframework.stereotype.Repository

@Repository
class PokemonTrainerDatabaseImpl(
    private var pokemonTrainerRepo: PokemonTrainerRepository
) : Database {

    override fun save(trainer: PokemonTrainer): PokemonTrainer {
        val pokemonTrainerEntity = PokemonTrainerEntity()
        this.pokemonTrainerRepo.save(pokemonTrainerEntity.toEntity(trainer))
        return trainer
    }

    override fun findById(id: Long): PokemonTrainer? {
        var trainerEntity = this.pokemonTrainerRepo.findById(id)

        if (trainerEntity.isPresent) {
            return trainerEntity.get().toDomain()
        }

        // TODO: throw custom exception of trainer not found
        return null
    }

}