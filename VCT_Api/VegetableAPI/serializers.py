from rest_framework import serializers
from .models import VegetablePrice, User


class VegetablePriceSerializer(serializers.ModelSerializer):
    class Meta:
        model = VegetablePrice
        field = '__all__'


class UserSerializer(serializers.ModelSerializer):
    class Meta:
        model = User
        fields = '__all__'