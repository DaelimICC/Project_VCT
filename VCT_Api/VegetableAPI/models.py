from django.db import models


class VegetablePrice(models.Model):
    vegetable_name = models.CharField(max_length=30)
    vegetable_price = models.IntegerField()
    vegetable_unit = models.CharField(max_length=50)


class VegetableCoin(models.Model):
    coin_name = models.CharField(max_length=50)
    coin_price = models.FloatField()
    coin_date = models.CharField(max_length=100)
