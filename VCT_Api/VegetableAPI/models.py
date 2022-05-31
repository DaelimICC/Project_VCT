from django.db import models


class VegetablePrice(models.Model):
    id = models.BigAutoField(primary_key=True)
    vegetable_name = models.CharField(unique=True)
    vegetable_price = models.IntegerField()
    vegetable_unit = models.CharField()
