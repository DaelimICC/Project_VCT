from rest_framework import serializers
from .models import VegetablePrice


class VegetablePriceSerializer(serializers.ModelSerializer):
    class Meta:
        model = VegetablePrice
        field = '__all__'
