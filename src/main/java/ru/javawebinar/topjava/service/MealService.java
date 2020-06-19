package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.ValidationUtil;

import java.util.Collection;

@Service
public class MealService {

    @Autowired
    private MealRepository repository;

    public Meal create(Meal meal) { return repository.save(meal); }

    public void delete(int id) {
        ValidationUtil.checkNotFoundWithId(repository.delete(id), id);
    }

    public Meal get(int id) { return ValidationUtil.checkNotFoundWithId(repository.get(id), id); }

    public Collection<Meal> getAll() { return repository.getAll(); }

    public void update(Meal meal) { ValidationUtil.checkNotFoundWithId(repository.save(meal), meal.getId()); }
}