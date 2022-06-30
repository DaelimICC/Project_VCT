from django.contrib.auth import authenticate
from django.contrib.auth.models import update_last_login
from rest_framework import serializers
from rest_framework_simplejwt.tokens import RefreshToken

from vct_auth.models import User
from vct_auth.validators import valid_email, valid_password, valid_nick, valid_phone


class LoginUserSerializer(serializers.Serializer):
    # email = serializers.EmailField()
    # password = serializers.CharField(max_length=128, write_only=True)
    # access = serializers.CharField(read_only=True)
    # refresh = serializers.CharField(read_only=True)
    class Meta:
        model = User
        fields = (
            'email',
            'password'
        )

    # def update(self, instance, validated_data):
    #     pass
    #
    # def validate(self, data):
    #     email = data['email']
    #     password = data['password']
    #     user = authenticate(username=email, password=password)
    #
    #     if user is None:
    #         return {
    #             'err': 'User DoesNotExist'
    #         }
    #
    #     try:
    #         refresh = RefreshToken.for_user(user)
    #         refresh_token = str(refresh)
    #         access_token = str(refresh.access_token)
    #         update_last_login(None, user)
    #
    #         valid_data = {
    #             'user': user,
    #             'access': access_token,
    #             'refresh': refresh_token
    #         }
    #
    #         return valid_data
    #     except user.DoesNotExist:
    #         raise serializers.ValidationError('User DoesNotExist')


class SignupUserSerializer(serializers.ModelSerializer):
    class Meta:
        model = User
        fields = (
            'email',
            'password',
            'nick',
            'phone'
        )

    def validate_email(self, email):
        valid_email(email)
        return email

    def validate_password(self, password):
        valid_password(password)
        return password

    def validate_nick(self, nick):
        valid_nick(nick)
        return nick

    def validate_phone(self, phone):
        valid_phone(phone)
        return phone

    def create(self, validated_data):
        user = User.objects.create_user(**validated_data)
        return user
