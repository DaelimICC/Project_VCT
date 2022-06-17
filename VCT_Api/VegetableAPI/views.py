import json
from django.views import View
from django.http import JsonResponse
from VegetableAPI.models import User


class UserView(View):
    def post(self, request):
        data = json.loads(request.body)

        Users = User.objects.create(
            user_Id=data["user_Id"],
            user_Nick=data["user_Nick"],
        )

        return JsonResponse({"message": "SUCCESS"}, status=201)