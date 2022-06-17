import json
from django.views import View
from django.http import JsonResponse
from VegetableAPI.models import User


class UserView(View):
    def post(self, request):
        data = json.loads(request.body)

        user = User.objects.create(
            user_Id=data["Id"],
            user_Nick=data["Nickname"],
        )

        return JsonResponse({"message": "SUCCESS"}, status=201)