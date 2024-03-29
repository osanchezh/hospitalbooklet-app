/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.osanchezhuerta.hospitalbooklet.soa.persistence.dao.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.osanchezhuerta.hospitalbooklet.soa.model.Vet;
import org.osanchezhuerta.hospitalbooklet.soa.persistence.dao.VetRepository;
import org.springframework.cache.annotation.Cacheable;

import org.springframework.stereotype.Repository;

/**
 * JPA implementation of the {@link VetRepository} interface.
 *
 */
@Repository
public class JpaVetRepositoryImpl implements VetRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
    @Cacheable(value = "vets")
    @SuppressWarnings("unchecked")
    public Collection<Vet> findAll() {
        return this.em.createQuery("SELECT vet FROM Vet vet join fetch vet.specialties ORDER BY vet.lastName, vet.firstName").getResultList();
    }

}
