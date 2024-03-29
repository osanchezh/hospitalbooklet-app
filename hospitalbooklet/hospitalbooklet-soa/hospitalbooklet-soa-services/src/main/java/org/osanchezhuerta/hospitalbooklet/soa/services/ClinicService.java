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
package org.osanchezhuerta.hospitalbooklet.soa.services;

import java.util.Collection;

import org.osanchezhuerta.hospitalbooklet.soa.model.Owner;
import org.osanchezhuerta.hospitalbooklet.soa.model.Pet;
import org.osanchezhuerta.hospitalbooklet.soa.model.PetType;
import org.osanchezhuerta.hospitalbooklet.soa.model.Vet;
import org.osanchezhuerta.hospitalbooklet.soa.model.Visit;
import org.springframework.dao.DataAccessException;




/**
 * Mostly used as a facade for all Petclinic controllers
 *
 */
public interface ClinicService {

    public Collection<PetType> findPetTypes() throws DataAccessException;

    public Owner findOwnerById(int id) throws DataAccessException;

    public Pet findPetById(int id) throws DataAccessException;

    public void savePet(Pet pet) throws DataAccessException;

    public void saveVisit(Visit visit) throws DataAccessException;

    public Collection<Vet> findVets() throws DataAccessException;

    public void saveOwner(Owner owner) throws DataAccessException;

    Collection<Owner> findOwnerByLastName(String lastName) throws DataAccessException;

}
