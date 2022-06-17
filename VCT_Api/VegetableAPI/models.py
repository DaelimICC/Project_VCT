from django.db import models


class VegetablePrice(models.Model):
    vegetable_name = models.CharField(max_length=30)
    vegetable_price = models.IntegerField()
    vegetable_unit = models.CharField(max_length=50)


class VegetableCoin(models.Model):
    coin_name = models.CharField(max_length=50)
    coin_price = models.FloatField()
    coin_date = models.CharField(max_length=100)


class User(models.Model):
    user_Id = models.CharField(max_length=50, primary_key=True)
    user_Nick = models.CharField(max_length=50)

    class Meta:
        db_table = 'Users'


class PurchaseCoin(models.Model):
    pc_user = models.ForeignKey("User", related_name='Purchase', on_delete=models.CASCADE, db_column='pc_user')
    pc_point = models.FloatField()
    pc_cucumber = models.IntegerField()
    pc_potato = models.IntegerField()
    pc_sweatpt = models.IntegerField()
    pc_galic = models.IntegerField()
    pc_cabbage = models.IntegerField()

    class Meta:
        db_table = 'PurchaseCoin'
